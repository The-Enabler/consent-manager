package in.projecteka.consentmanager.link.hiplink.model.request;

import lombok.Value;

@Value
public class Query {
    Patient patient;
    String purpose;
    Requester requester;
}
