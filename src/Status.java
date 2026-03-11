public enum Status {
    AVAILABLE{
        @Override
        public void showLocation(){
            System.out.println("On the shelf");
        }
    },
    LOANED{
        @Override
        public void showLocation(){
            System.out.println("Currently with a member");
        }
    },
    RESERVED{
        @Override
        public void showLocation(){
            System.out.println("Waiting for a specific member");
        }
    },
    LOST_DAMAGED{
        @Override
        public void showLocation(){
            System.out.println("Not fit for circulation");
        }

    };
    public abstract void showLocation();
}
