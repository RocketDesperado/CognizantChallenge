package com.example.demo.domain.composites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestCompilerJson {

    private final static String JAVA = "java";

    private final static String VERSION_INDEX = "0";

    private final static String CLIENT_SECRET = "f2ac027303498c35bd2996dbdefa20bd8b66dd8afebe362728d5da6ca48a268f";

    private final static String CLIENT_ID = "98d3d2ce9b82ba74ccd71cc2aa60f1b8";

    private final static String STDIN = "";

    private String clientId;

    private String clientSecret;

    private String script;

    private String stdin;

    private String language;

    private String versionIndex;


    public RequestCompilerJson(String script) {
        this.script = script;
        this.clientId = CLIENT_ID;
        this.clientSecret = CLIENT_SECRET;
        this.stdin = STDIN;
        this.language = JAVA;
        this.versionIndex = VERSION_INDEX;
    }

    public String getScript() {
        return script;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getStdin() {
        return stdin;
    }

    public String getLanguage() {
        return language;
    }

    public String getVersionIndex() {
        return versionIndex;
    }
}
