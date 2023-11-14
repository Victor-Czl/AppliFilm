1)
class Ville(val nom : String, val rating : Int) {}

2)
var toulouse = Ville(«Toulouse», 20)
var narbonne = Ville(«Narbonne», 15)
var coucouron = Ville(«Coucouron», 15)

var villes = listOf(toulouse, narbonne, coucouron)

3)
villes.filter { it.rating > 2 }.forEach { println(it.nom) } 

4)
val villesTab = villes.map { it["nom"], it["rating"])}

5)
villes.map { it["nom"], it["rating"])}.filter { it.rating > 2 }.forEach {println(it.nom)}


6)
fun affStars() : String {
	return "*".repeat(rating)
}

			OU

fun affStars() : String {
	var r = ""
	for(f in 1..rating) r = r + "*"
	return r
}

7)
villesTab.filter { it.rating > 2}.map { it.nom + " " + it.affstars()}.forEach { println(it) }
