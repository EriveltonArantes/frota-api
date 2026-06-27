package com.frotaapi.dto;

import jakarta.validation.constraints.*;

public class ManutencaoRequestDTO {

    @NotNull(message = "VeiculoId é obrigatório")
    @Positive(message = "VeiculoId deve ser um ID válido (positivo)")
    private Long veiculoId;
    @NotNull(message = "data entrada não pode ser nulo")
    private java.time.LocalDateTime dataEntrada;
    @NotBlank(message = "tipo não pode estar em branco")
    private String tipo;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @DecimalMin(value = "0.0", message = "custo não pode ser negativo")
    @NotNull(message = "custo não pode ser nulo")
    private java.math.BigDecimal custo;
    @NotBlank(message = "oficina não pode estar em branco")
    private String oficina;
    @NotNull(message = "data saida não pode ser nulo")
    private java.time.LocalDateTime dataSaida;

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
