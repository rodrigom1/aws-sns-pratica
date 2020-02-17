package br.com.sns.client;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

public class AWSSNSConfig {

    public static AmazonSNS amazonSNSClient() {
        return AmazonSNSClientBuilder.defaultClient();

        //1 - Variáveis de ambiente–AWS_ACCESS_KEY_ID e AWS_SECRET_ACCESS_KEY
        //2 - Propriedades do sistema Java–aws.accessKeyId e aws.secretKey
        //3 - O arquivo de perfis de credencial padrão (~/  .aws/credentials)
        //4 - Credenciais de contêiner do Amazon ECS (variável de ambiente)
        //5 - Credenciais de perfil da instância (metadados da EC2)
    }
}
