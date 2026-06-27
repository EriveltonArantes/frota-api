package com.frotaapi.dto;

import jakarta.validation.constraints.*;

public class MotoristaRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cnh não pode estar em branco")
    private String cnh;
    @NotBlank(message = "categoria cnh não pode estar em branco")
    private String categoriaCnh;
    @NotNull(message = "validade não pode ser nulo")
    private java.time.LocalDateTime validade;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotNull(message = "disponivel não pode ser nulo")
    private Boolean disponivel;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCnh() { return cnh; }
    public void setCnh(String cnh) { this.cnh = cnh; }
    public String getCategoriaCnh() { return categoriaCnh; }
    public void setCategoriaCnh(String categoriaCnh) { this.categoriaCnh = categoriaCnh; }
    public java.time.LocalDateTime getValidade() { return validade; }
    public void setValidade(java.time.LocalDateTime validade) { this.validade = validade; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public Boolean getDisponivel() { return disponivel; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
}
