package br.com.senior.employee.consumer.pojos.authentication;

public enum UserOTPAuthStatusDTO {
    /**
     * Ainda não configurado pelo usuário.
     */
    UNCONFIGURED,
    /**
     * Já configurado pelo usuário, código de validação da configuração foi informado.
     */
    CONFIGURED,
    /**
     * A chave foi regerada e o usuário precisa configurar o SoftToken novamente.
     */
    RESETTED
}

