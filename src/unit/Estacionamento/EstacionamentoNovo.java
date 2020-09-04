package unit.Estacionamento;

public class EstacionamentoNovo {

    private int codigo;
    private String nome;
    private String cidade;
    private int vagas;
    private int vagasUsadas;
    private boolean situacao;
    private float valorInicial;
    private float valorAdicional;
    private int horaFranquiaInicial;

    public EstacionamentoNovo (int codigo, String nome, String cidade, int vagas){
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
        this.vagas = vagas;
        vagasUsadas = 0;
        situacao = true;
    }

    public int getVagasUsadas() {
        return vagasUsadas;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public int getVagas() {
        return vagas;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public float getValorAdicional() {
        return valorAdicional;
    }

    public int getHoraFranquiaInicial() {
        return horaFranquiaInicial;
    }

    public void setVagasUsadas(int vagasUsadas) {
        this.vagasUsadas = vagasUsadas;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }

    public void setValorAdicional(float valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public void setHoraFranquiaInicial(int horaFranquiaInicial) {
        this.horaFranquiaInicial = horaFranquiaInicial;
    }

    public void ativar(boolean ativar){
        situacao = ativar;
    }

    public void desativar (boolean desativar){
        situacao = desativar;
    }
}
