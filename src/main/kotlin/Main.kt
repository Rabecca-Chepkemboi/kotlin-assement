fun main(){
    val story1 = AncestralStories(250, "Bad leadership", 14)  //instantiation for base class
    story1.getStoryDetails()
    val story2 = StoryTeller(250, "Neo colonialism", 14, "Ken Walibora") //instantiation          of story teller class
    story2.getStoryTellerDetails()
    val story3 = Translator(250, "Poverty", 14, "Bertolt bretch")  //instantiation of translator class
    println( story3.translateStory("English"))


    val food = Recipe("too spicy", "2 hours", "long", "too informative" )
    food.knowRecipes()

    val taste = MoroccanRecipe("corriander", "30 minutes", "important", "short", "sweet", "cocont oil")
    taste.knowRecipes()

    val flavour = EthiopianRecipe("galic", "1 hour", "less important", "traditional fire", "pungent", "brown")
    flavour.knowRecipes()
    val texture = NigerianRecipe("onions", "1/2 hours", "poor", "gas", "long", "rough")
    texture.knowRecipes()


    var artist = Artist("jayz","Canada","hiphop", instruments = listOf("guitar","piano",))
    println(artist.artistDetail())
    var perform = Performance("sautisol","Kenya","bongo", instruments = listOf("guitar","piano"),"2 hours")
    println(perform.scheduling())
    println(perform.playInstrument("guitar"))
    var stage = Stage("Bridget blue","Kenya","gospel", instruments = listOf("piano","harp","violin",),100,"Nakuru")
    println(stage.performance())


    var price1 = Product("Bread",50.00,10)
    var price2 = Product("Orange",60.00,10)
    var price3 = Product("Spread",120.00,5)
    var price4 = Product("Book",210.00,1)
    var totalPrice = price1.totalValue() + price2.totalValue() +price3.totalValue()+price4.totalValue()
    println(totalPrice)

}


//question 1

open class AncestralStories(var lengthInPages:Int, var lesson:String, var ageGroup:Int) {    //declaration of base class that takes in length, lesson,age grp
    open fun getStoryDetails() {   //method to display details of each story
        if (ageGroup in 1..5) {    //grouping ages in ranges to find reading level
            println("Length:$lengthInPages pages, Lesson:$lesson, Age Group:Level 1")
        } else if (ageGroup in 6..12) {
            println("Length:$lengthInPages pages, Lesson:$lesson, Age Group:Level 2")
        } else if (ageGroup in 13..17) {
            println("Length:$lengthInPages pages, Lesson:$lesson, Age Group:Level 3")
        } else {
            println("Length:$lengthInPages pages, Lesson:$lesson, Age Group:Level 4")
        }
    }
}
class StoryTeller(lengthInPages: Int, lesson: String, ageGroup: Int, var name: String):AncestralStories(lengthInPages, lesson, ageGroup){
    fun getStoryTellerDetails() {  //overrides fun in base class in order to add name of storyteller
        if (ageGroup in 1..5){
            println("Length:$lengthInPages pages, Lesson:$lesson, Age Group:Level 1, Storyteller:$name")
        }
        else if (ageGroup in 6..12){
            println("Length:$lengthInPages pages, Lesson:$lesson, Age Group:Level 2, storyteller:$name")
        }
        else if (ageGroup in 13..17){
            println("Length:$lengthInPages pages, Lesson:$lesson, Age Group:Level 3, storyteller:$name")
        }
        else {
            println("Length:$lengthInPages pages, Lesson:$lesson, Age Group:Level 4, storyteller:$name")
        }
    }
}
class Translator(lengthInPages: Int, lesson: String, ageGroup: Int, var name: String):AncestralStories(lengthInPages, lesson, ageGroup){  //declaration of class translator that holds details of the translator, inherits from base class
    fun translateStory(language:String):String{  //method, takes in language to be translated to, and translates the story
        return "Story translated to $language"
    }
}

//question 2

open class Recipe(var ingredients: String, var preparationTime: String, var cookingMethod: String, var nutritionalInformation: String){
    open fun knowRecipes(){
        println("Ingredients is $ingredients, preparation time is $preparationTime, cooking method is $cookingMethod and nutritional value is $nutritionalInformation")
    }
}


class MoroccanRecipe(ingredients: String, preparationTime: String, nutritionalInformation: String, cookingMethod: String, var taste: String, var oil: String): Recipe(ingredients, preparationTime, cookingMethod, nutritionalInformation){
    override fun knowRecipes() {
        super.knowRecipes()
        println("Moroccan food has a $taste test, and is cooked using $oil")
    }
}


class EthiopianRecipe(ingredients: String, preparationTime: String, nutritionalInformation: String, cookingMethod: String, var flavour: String, var color: String): Recipe(ingredients, preparationTime, cookingMethod, nutritionalInformation){
    override fun knowRecipes() {
        super.knowRecipes()
        println("Ethiopian food is , has a $flavour flavour and is mostl $color in color")
    }
}


class NigerianRecipe(ingredients: String, preparationTime: String, nutritionalInformation: String, cookingMethod: String, var preservationMethod: String, var texture: String):Recipe(ingredients, nutritionalInformation, cookingMethod, preparationTime){
    override fun knowRecipes() {
        super.knowRecipes()
        println("Nigerian food has a $preservationMethod, reserved method, is a always $texture in texture")
    }
}


//question 4

open class Artist(var name:String, var country:String, var musicType:String, var instruments:List<String>){
    fun artistDetail(){
        println("name:$name, country:$country, musicType:$musicType, instruments:${instruments.joinToString()}")
    }
}
class Performance(name: String, country: String, musicType: String, instruments: List<String>, var stageTime:String):Artist(name,country,musicType,instruments){
    fun scheduling(){
        println("name:$name, musicType:$musicType, time:$stageTime")
    }
    fun playInstrument(instrument:String){
        if (instruments.contains(instrument)){
            println("$name is playing $instrument")
        }
        else{
            println("$name is not playing $instrument")
        }
    }
}
class Stage(name: String, country: String, musicType: String, instruments: List<String>, var capacity:Int,var location:String):Artist(name,country,musicType,instruments){
    fun performance(){
        println("name:$name, country:$country, musictype:$musicType, capacity:$capacity, place:$location")
    }
}


//question5

class Product(var name:String,var price:Double, var quantity:Int){
    fun totalValue():Double{
        return price * quantity
    }
}