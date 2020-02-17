package br.com.sns;

import br.com.sns.bean.Produto;
import br.com.sns.service.SNSService;

public class SNSTest {

    public static void main(String[] args) {
        SNSService snsService = SNSService.getInstance();
        Produto produto = new Produto(1, "bicicleta");

        snsService.publish(produto);

    }


}


