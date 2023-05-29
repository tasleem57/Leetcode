class ParkingSystem {
    private int[] spots;

    public ParkingSystem(int big, int medium, int small) {
        spots = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (spots[carType - 1] > 0) {
            spots[carType - 1]--;
            return true;
        } else {
            return false;
        }
    }
}