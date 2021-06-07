package parallel;

public enum Price {
    ПО_УМОЛЧАНИЮ("По умоланию"),
    ДЕШЕВЛЕ("Дешевле"),
    ДОРОЖЕ("Дороже"),
    ПО_ДАТЕ("По дате");


    public String priceValue;
    public String getPriceValue(){
        return priceValue;
    }
    Price(String priceValue){
        this.priceValue = priceValue;
    }
}
