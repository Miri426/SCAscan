package org.owasp.webgoat.vulnerable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VulnerableComponent {
    // Vulnerable Log4j pattern
    private static final Logger logger = LogManager.getLogger(VulnerableComponent.class);
    
    public void vulnerableLog4jMethod(String userInput) {
        // This is vulnerable to CVE-2021-44228 (Log4Shell)
        logger.error("User input: " + userInput);
    }
    
    // Vulnerable Jackson pattern
    public void vulnerableJacksonMethod(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // This is vulnerable to various Jackson CVEs when processing untrusted input
        mapper.enableDefaultTyping();
        Object obj = mapper.readValue(json, Object.class);
    }
    
    // Another vulnerable pattern with older Jackson
    public void deserializeWithUntrustedInput(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        // Vulnerable to CVE-2017-7525 and others
        mapper.readValue(json, Object.class);
    }
}