import scala.collection.mutable
import scala.io.Source
import scala.util.{Try, Using}


case class Rectangle_(
  id : Int,
  x_start : Int,
  x_end : Int,
  y_start : Int,
  y_end : Int
)

def read_and_clean_(): List[Rectangle_] = {
  Using(Source.fromFile("src/main/resources/real")) { file =>
    file.getLines().map { row =>
      get_rectangle_from_row_(row)
    }.toList
  }.get
}


def get_rectangle_from_row_(row:String): Rectangle_ = {

  // On supprimes les symboles "#", "@ ", ":" sur chaque lignes
  val details = row.replaceAll("[#:]", "").replace("@ ", "").split(" ")

  // On récupère l'ID
  val id = details(0).toInt

  // On récupère l'écart du rectangle avec le bord gauche et haut
  val (x_start, y_start) = {
    val parts = details(1).split(",")
    (parts(0).toInt, parts(1).toInt)
  }

  // On récupère les dimensions du rectangle
  val (largeur_rectangle, hauteur_rectangle) = {
    val parts = details(2).split("x")
    (parts(0).toInt, parts(1).toInt)
  }

  // On calcule la fin du rectangle
  val x_end = x_start + largeur_rectangle
  val y_end = y_start + hauteur_rectangle

  // On crée le dictionnnaire correspondant à la ligne
  Rectangle_(
    id = id,
    x_start = x_start,
    y_start = y_start,
    x_end = x_end,
    y_end = y_end
  )
}


@main
def main_(): Unit = {

  // On récupère la liste de dictionnaire d'instructions
  val liste_rectangles: List[Rectangle_] = read_and_clean_()
  println(liste_rectangles)

  // On calcule le nombre d'instructions
  val nb_instr = liste_rectangles.length

  // On génèreun array 2D rempli de 0
  val grid: Array[Array[Int]] = Array.fill(1000, 1000)(0)
  println()

  // On crée un set qui stocke les ID ayant été surchargés dans la grille
  val set_id_overlap: mutable.Set[Int] = mutable.Set() ++ (1 to nb_instr)

  // Pour chaque Rectangle
  for (rectangle <- liste_rectangles){

    // On parcours les dimensions du Rectangle
    for (x <- rectangle.x_start until rectangle.x_end;
         y <- rectangle.y_start until rectangle.y_end) {

      // On récupère la case actuelle de la grille
      val current_grid_value = grid(y)(x)

      // Si la case est vide
      if (current_grid_value == 0){
        grid(y)(x) = rectangle.id
      }

      // Si un id a déja été affecté à la case
      else{
        grid(y)(x) = -1
        set_id_overlap -= current_grid_value
        set_id_overlap -= rectangle.id
      }
    }
  }

//  for (i <- 0 until 1000){
//    println(grid(i).mkString(" "))
//  }

  println(set_id_overlap)

}

