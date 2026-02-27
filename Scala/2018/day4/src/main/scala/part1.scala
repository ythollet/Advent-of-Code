import org.apache.spark.sql.functions.{regexp_extract, _}
import org.apache.spark.sql.{DataFrame, SparkSession}



object get_data {
  def txt_to_df(): DataFrame = {

    val spark = SparkSession.builder()
      .appName("read_txt")
      .master("local[*]")
      .getOrCreate()



    // On récupère les données lignes par lignes mais avec une seule colonne
    val df_brut: DataFrame = spark.read.text("src/main/resources/test")


    // On split le DataFrame d'une colonne en 2 colonnes (timestamp et le reste)
    val df_timestamp: DataFrame = df_brut.select(
      regexp_extract(
        col("value"),
        "\\[(.*?)\\]",
        1
      ).alias("time"),

      regexp_extract(
        col("value"),
        "\\] (.*)$",
        1
      ).alias("col2")
    )

    // On split en 3 colonnes (Timestamp, identifiant du garde, statut du garde)
    val df_timestamp_id = df_timestamp.withColumn(
      "guard_id",
      regexp_extract(
        col("col2"),
        "Guard #(\\d+)",
        1
      )
    )

    // On met au propre le DataFrame
    val df_timestamp_id_clean = df_timestamp_id
      .withColumn(
        "col2",
        trim(regexp_replace(col("col2"), "Guard #\\d+ begins shift", "start"))
      )
      .withColumn(
      "col2",
      trim(regexp_replace(col("col2"), "falls asleep", "end"))
      )
      .withColumn(
        "col2",
        trim(regexp_replace(col("col2"), "wakes up", "start"))
      )

    df_timestamp_id_clean
  }
}


object Main {
  def main(args: Array[String]): Unit = {
    val df: DataFrame = get_data.txt_to_df()
    df.show()

  }
}