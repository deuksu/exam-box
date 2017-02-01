package com.exam.security.facebook.domain;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class FacebookUserDeserializer extends JsonDeserializer<FacebookUser> {

  @Override
  public FacebookUser deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {
    FacebookUser user = new FacebookUser();
    ObjectCodec oc = p.getCodec();
    JsonNode node = oc.readTree(p);
    user.setId(getNodeString(node.get("id")));
    user.setName(this.getNodeString(node.get("username")));
    user.setEmail(getNodeString(node.get("email")));
    return user;
  }
  
  private String getNodeString(JsonNode jsonNode) {
    return jsonNode == null ? "" : jsonNode.asText();
  }
  
}
