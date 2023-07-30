public class Basket
{
    int numPeople ; // для проверки кол-ва гостей
    String itemAll  ; // сбор товаров
    float priceAll  ; // общаяя сумма товаров
    float divisionAll ; // для определения доли гостя
    String rubEnd  ; // правильное окончание рубля

    public void division () // для определения доли
    {
      divisionAll = priceAll / numPeople ;
    }

} // от public class Basket
