class Car {
    String model;
    String color;
    double price;

    Car(String model, String color) {
        this.model = model;
        this.color = color;

        if (model.equalsIgnoreCase("delta"))
            price = 800000;
        else if (model.equalsIgnoreCase("beta"))
            price = 1000000;
        else if (model.equalsIgnoreCase("alfa"))
            price = 1200000;
        else {
            System.out.println("Invalid model!");
            price = 0;
        }
    }
}
