package soselab.easylearn.client;


import feign.Client;
import feign.Feign;
import soselab.easylearn.model.JacksonDecoder;
import soselab.easylearn.model.JacksonEncoder;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class ClientFactory {
    public static final Client disableHostnameVerification =
            new Client.Default(TrustingSSLSocketFactory.get(), new HostnameVerifier() {
                @Override
                public boolean verify(String s, SSLSession sslSession) {
                    return true;
                }
            });

    public static final <T> T getClient(Class<T> targetType) {
        return Feign.builder()
                .client(ClientFactory.disableHostnameVerification)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(targetType, "https://dev.microservices.ntou.edu.tw");
    }
}
