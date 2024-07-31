package br.com.itau.desafio.infra;

public interface IConverterDadosJson {
    <T> T obterDados(String json, Class<T> tClass);
}
