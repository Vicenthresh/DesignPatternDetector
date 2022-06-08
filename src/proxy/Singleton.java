package proxy;

public final class Singleton {
    public static class RealClass{

        private static RealClass Instancia = new RealClass();
        private RealClass(){ }
        public static RealClass getInstance(){
            return Instancia;
        }

    }
    public static class FakeClass{

        private static FakeClass Instancia = new FakeClass();
        public FakeClass(){ }
        public static FakeClass getInstance(){
            return Instancia;
        }

    }

}
