package veiculo;

public interface ParteTrem {
    public boolean atrelaAoTrem(Trem trem);

    public void desatrelaDoTrem();

    public int getId();

    public double getMaximaCapacidade();
}
