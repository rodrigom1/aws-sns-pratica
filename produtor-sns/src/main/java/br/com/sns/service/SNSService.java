package br.com.sns.service;

import br.com.sns.bean.Produto;
import br.com.sns.client.AWSSNSConfig;
import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishResult;
import org.json.JSONObject;

public class SNSService {

    public static SNSService snsService;

    public static SNSService getInstance() {
        if (snsService == null) {
            snsService = new SNSService();
        }
        return snsService;
    }

    public String publish(String message) {
        AmazonSNS amazonSNS = AWSSNSConfig.amazonSNSClient();

        try {
            PublishResult publishResult = amazonSNS.publish("seu_arn_do_sns:produtos", message);

            return publishResult.getMessageId();

        } catch (AmazonServiceException se) {
            System.out.printf("statusCode: %s, message: %s", se.getStatusCode(), se.getMessage());
        } catch (AmazonClientException ce) {
            System.out.println(ce);
        }

        return null;
}

    public String publish(Produto produto) {
        JSONObject jsonObject = new JSONObject(produto);
        return publish(jsonObject.toString());
    }
}
