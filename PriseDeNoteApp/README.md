# Prise-de-note

## Manuelle Technique
 
 Cette application de Prise de à pour but de créer des note, de les modifier, supprimer, visualiser en tant reéel avec ASCIIDOCTOR et de faire des recherches de mot à l'interieur des fichiers.
 
 Lidée de la conception est qu'a la créaton de chaque note, l'utilisateur n'entre que le nom de la nouvelle note.
 
   La note est donc **créée** avec une extension .adoc et a comme contest: _DefaultContest_ et comme Projet: _DefaultProject_. La date est prise automatiquement par le système. Une fois la note créée, il est ensuite ouvert par un éditeur de test chois par l'utlisateur an sle fichier de configuration. Après la fermeture de l'éditeur par l'utilisateur, le systme vérifie si le contest et/ou le projet ont été modifier Si oui, il les mofient dans la structure de la note. Chaque note est alors ajouter dans une liste qui correspond à son projet et dans une autre qui correspond à son context. Cette liste eest stockée dans un élément unique, qui a pour objectif de garder l'état de l'application. Le contenue de cette liste est stocké dans un fichier qui estmis a jour a chaque modification. Au lancement de l'application, l'élément unique va chercher le dernier état de l'application et le sauvegarde. 

   Une notes peut être **supprimée** si elle esiste dans la liste des note. Dans ce cas, elle est supprimer de la liste des notes, de son groupe de projet, de contest et date. Le fichier de la note est aussi supprimer du disque.
  
   Une note peut être **visualisée** en temps réelle. On lance à l'aide de commandes du terminale un navigateur à qui on demande d'ouvri le fichier.
   
   >Note :  On doit au préalable avoir installé le pluggin de ascii doctor dans le navigateur.
    
   Nous pouvons **lister** toutes les notes. Dans ce cans on a qu'a afficher le nom des notes présentes dans la liste de toutes les notes de l'élément unique, suivie du nombre de notes trouvé.
  
 Des recherches peuvent aussi être faites dans les fichiers.
 
 A chaque modification un fichier index.adoc. Il est organisé de la manière suivante:
  - Toutes les notes listées dans l'ordre alphabétique
  - Les notes par Projets
  - Les notes par Contexte
  - Les notes par date
  
  
 ### Conception
 
 Pour le réaliser, nous nous somme basé sur 3 patterns:
 
  - Le Builder Patern pour la création d'une note 
  - Le Patern Composite  pour le classement des notes selon leur context, groupe et date
  - Le Command Patern
  - Le Singleton pour maintenir l'état de l'application 
  
  ## Guide D'utilisation
  
 Pour utiliser l'application, l'utilisateur doit commencer par installer le pluging de ASCIIDOCTOR dans le navigateur qu'il souhaiterai utiliser.
 
 Ensuite, dans un terminal il doit saisir "note" suivie de la commande voulu. Les commandes sont:
	 - e|edit 'nom de la note'    :    Pour créer ou modifier une note
		- v|view 'nom de la note'    :    Pour visualiser une note
	 - d|delete 'nom de la note'  :    Pour supprimer une note
		- s|search 'mot clé'         :    Pour chercher un mot clé dans les notes
		- ls|list                    :    Pour affichier la liste des fichiers du répertoire
  
  
  Pour l'écriture dans le fichier l'utilisateru doit utiliser le slanguage de balisage ASCIIDOCTOR. 
			
  
  
  
 
 
 
 
 
