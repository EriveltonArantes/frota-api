package com.frotaapi.dto;

public class ManutencaoResponseDTO {

    private Long id;
    private Long veiculoId;
    private java.time.LocalDateTime dataEntrada;
    private String tipo;
    private String descricao;
    private java.math.BigDecimal custo;
    private String oficina;
    private java.time.LocalDateTime dataSaida;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getVeiculoId() { return veiculoId; }
    public void setVeiculoId(Long veiculoId) { this.veiculoId = veiculoId; }
    public java.time.LocalDateTime getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(java.time.LocalDateTime dataEntrada) { this.dataEntrada = dataEntrada; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public java.math.BigDecimal getCusto() { return custo; }
    public void setCusto(java.math.BigDecimal custo) { this.custo = custo; }
    public String getOficina() { return oficina; }
    public void setOficina(String oficina) { this.oficina = oficina; }
    public java.time.LocalDateTime getDataSaida() { return dataSaida; }
    public void setDataSaida(java.time.LocalDateTime dataSaida) { this.dataSaida = dataSaida; }
}
