package DesignPatterns.Singleton;

public class ChocolateBoilerEarlyInitialization {

        private static ChocolateBoilerEarlyInitialization chocolateBoiler = new ChocolateBoilerEarlyInitialization();
        private boolean empty;
        private boolean boiled;

        private ChocolateBoilerEarlyInitialization() {
            empty = true;
            boiled = false;
        }

    /* Since synchronization is costly we can use early initialization if we are sure
     our application always creates and uses instance of singleton*/
        public static synchronized ChocolateBoilerEarlyInitialization getChocolateBoilerEarlyInitialization() {
            return chocolateBoiler;
        }

        public boolean isEmpty() {
            return empty;
        }

        public boolean isBoiled() {
            return boiled;
        }

        public void fill() {
            if(isEmpty()) {
                empty = false;
                boiled = false;
            }
        }

        public void drain() {
            if(!isEmpty() && isBoiled()) {
                empty = true;
            }
        }

        public void boil() {
            if(!isEmpty() && !isBoiled()) {
                boiled = true;
            }
        }
    }
