# Rogue_like
README ROGUE_lIKE

  L'expressionn RogueLike tire de son nom du jeu Rogue,donc similaire a Rogue .
  Chaque element du jeu y compris les noms vivants ,mais aussi les personnages 
  et les monstres , est donc représenté visuellement.
  Cela consiste a avoir des joueurs (H)  qui peuvent combattre  Une quantite de montres a chaque niveau.
  
  MANUEL TECHNIQUE:
  -
 L'univers de jeu se présente sous la forme d'un tableau  dont chaque case correspond à un symbole ASCII.
 Ces symboles  (les elements de l'univers)  représentent le sol, les murs, ainsi que les objets et les etres vivants.
 Cet univers doit être généré aléatoirement à chaque début de partie: la disposition des différentes pièces, 
 ainsi que l'emplacement des objets des etres vivants  et des monstres.
 Le jeu comporte également des personnages non joueur (PNJ). 
  
OBJECTIF DU JOUEUR:
- L'objectif des joueurs est de gagner.Pour cela il doit se placer dans l'univers de jeu pour combattre les monstres.
,il peut etre aussi combattu par les monstres.

Les joueurs et des monstres possède des caractéristiques (points de vie) .Ces PV peuvent diminuer en fonction des combats.
Par exemple si le joueur combat un monstre ,les PV du monstre diminuent de 20 points.
Et quand un monstre combat le joueur ,les PV  du joueur diminue de 4points.
Pour survivre le joueur doit ramasser des nouritures pour manger ,combattre le monstre et coutourner les murs.
Pour passer d'un niveau a un autre ,on doit retrouver l'escalier meme si on a pas tuer tous les monstres du niveau précédent.

LES FONCTIONNALITES PRINCIPALES:
-
-Se deplacer dans le labyrinthe
-Interagir avec  l'environnement (ramasser ou utiliser un objet, discuter avec un PNJ, ).
-Combattre un vivant

Regles de jeu:
-
Taper entrer pour demarrer le jeu 
Cliquer sur Ctrl+Z pour combattre un monstre  


