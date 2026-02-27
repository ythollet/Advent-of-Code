# 🎄 Advent of Code - Solutions

Ce dépôt contient mes solutions pour les défis de l'[Advent of Code](https://adventofcode.com/), un calendrier de l'Avent annuel composé de puzzles de programmation.

L'objectif de ce projet est de résoudre ces casse-têtes algorithmiques en explorant différents langages de programmation et différentes approches.

## 📂 Structure du Projet
Le dépôt est organisé par langage de programmation, puis par année et enfin par jour de défi.

Actuellement, les langages explorés sont :

### 🐍 Python (`/Python`)
Les solutions en Python sont principalement développées sous forme de Notebooks Jupyter (`.ipynb`), ce qui permet une exécution étape par étape et une exploration interactive des données.

* **2015** : Jours 1 à 20
* **2016** : Jours 1 à 11
* **2024** : Jours 1 à 18

### 🔴 Scala (`/Scala`)
Les solutions en Scala sont structurées sous forme de projets classiques utilisant sbt (Scala Build Tool).

* **2018** : Jours 3 et 4 (et autres expérimentations)

## 🧩 Structure d'un dossier journalier
Pour chaque jour (par exemple `Python/2015/Day1/` ou `Scala/2018/day3/`), vous trouverez généralement la structure suivante :

* `consignes.txt` : L'énoncé du problème pour ce jour.
* `test.txt` / `test2.txt` : Les données d'exemple fournies dans l'énoncé pour valider la logique.
* `real.txt` : L'input (données d'entrée) officiel et personnel pour résoudre le puzzle.
* `part1.*` / `part2.*` : Les scripts ou notebooks contenant la logique de résolution pour la partie 1 et la partie 2 du défi.

## 🚀 Comment exécuter le code ?

### Pour les solutions Python (Jupyter Notebooks)
Assurez-vous d'avoir installé Python 3.

Installez Jupyter si ce n'est pas déjà fait :

```bash
pip install jupyter
```

Lancez le serveur Jupyter à la racine du dossier Python :

```bash
jupyter notebook
```

(Vous pouvez également ouvrir les fichiers `.ipynb` directement dans VS Code ou PyCharm s'ils sont configurés pour).

### Pour les solutions Scala
Assurez-vous d'avoir installé Java (JDK) et sbt.

Naviguez dans le répertoire du jour souhaité (ex: `Scala/2018/day3`).

Lancez la compilation et l'exécution via sbt :

```bash
sbt run
```

## 📜 Licence & Avertissement
Les données d'entrée (`real.txt`) et les textes des énigmes (`consignes.txt`) sont la propriété intellectuelle exclusive d'Advent of Code et de son créateur Eric Wastl. Ce dépôt a un but purement éducatif et personnel.