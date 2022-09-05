package veiculo;
public class Vagao implements ParteTrem{
    private int id;
    private double maximaCapacidade;
    private Trem tremAtual;

    public Vagao(int id, double maximaCapacidade){
        this.id = id;
        this.maximaCapacidade = maximaCapacidade;
        this.tremAtual = null;
    }
    
    public boolean atrelaAoTrem(Trem trem){
        if(this.tremAtual != null){
            return false;
        }
        this.tremAtual = trem;
        return true;
    }

    public void desatrelaDoTrem(){
        this.tremAtual = null;
    }

    public int getId() {
        return this.id;
    }

    public double getMaximaCapacidade(){
        return this.maximaCapacidade;
    }

    @Override
    public String toString() {
        String str = "ID: " + this.id + "; Trem atual: ";
        if(this.tremAtual == null){
            str += "nenhum";
        }else{
            str += this.tremAtual.getId();
        }
        return str;
    }
}
