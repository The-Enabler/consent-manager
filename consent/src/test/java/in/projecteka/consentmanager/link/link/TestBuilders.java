package in.projecteka.consentmanager.link.link;

import in.projecteka.consentmanager.clients.model.PatientLinkReferenceRequest;
import in.projecteka.consentmanager.clients.model.PatientLinkReferenceResponse;
import in.projecteka.consentmanager.clients.model.PatientLinkReferenceResult;
import in.projecteka.consentmanager.clients.model.PatientLinkRequest;
import in.projecteka.consentmanager.clients.model.PatientRepresentation;
import in.projecteka.consentmanager.link.hiplink.model.request.UserAuthConfirmRequest;
import in.projecteka.consentmanager.link.link.model.AuthzHipAction;
import in.projecteka.consentmanager.link.link.model.LinkRequest;
import in.projecteka.consentmanager.link.link.model.Links;
import in.projecteka.consentmanager.link.link.model.PatientLinks;
import in.projecteka.library.clients.model.User;
import org.jeasy.random.EasyRandom;

public class TestBuilders {

    private static final EasyRandom easyRandom = new EasyRandom();

    public static in.projecteka.consentmanager.link.link.model.PatientLinkReferenceRequest.PatientLinkReferenceRequestBuilder patientLinkReferenceRequest() {
        return easyRandom.nextObject(in.projecteka.consentmanager.link.link.model.PatientLinkReferenceRequest.PatientLinkReferenceRequestBuilder.class);
    }

    public static PatientLinkRequest.PatientLinkRequestBuilder patientLinkRequest() {
        return easyRandom.nextObject(PatientLinkRequest.PatientLinkRequestBuilder.class);
    }

    public static PatientLinkReferenceResponse.PatientLinkReferenceResponseBuilder patientLinkReferenceResponse() {
        return easyRandom.nextObject(PatientLinkReferenceResponse.PatientLinkReferenceResponseBuilder.class);
    }

    public static PatientLinks.PatientLinksBuilder patientLinks() {
        return easyRandom.nextObject(PatientLinks.PatientLinksBuilder.class);
    }

    public static Links.LinksBuilder links() {
        return easyRandom.nextObject(Links.LinksBuilder.class);
    }

    public static PatientRepresentation.PatientRepresentationBuilder patientRepresentation() {
        return easyRandom.nextObject(PatientRepresentation.PatientRepresentationBuilder.class);
    }

    public static User.UserBuilder user() {
        return easyRandom.nextObject(User.UserBuilder.class);
    }

    public static String string() {
        return easyRandom.nextObject(String.class);
    }

    public static PatientLinkReferenceResult.PatientLinkReferenceResultBuilder patientLinkReferenceResult() {
        return easyRandom.nextObject(PatientLinkReferenceResult.PatientLinkReferenceResultBuilder.class);
    }

    public static PatientLinkReferenceRequest.PatientLinkReferenceRequestBuilder linkReferenceRequest() {
        return easyRandom.nextObject(PatientLinkReferenceRequest.PatientLinkReferenceRequestBuilder.class);
    }

    public static LinkRequest.LinkRequestBuilder linkRequest() {
        return easyRandom.nextObject(LinkRequest.LinkRequestBuilder.class);
    }

    public static AuthzHipAction.AuthzHipActionBuilder linkHipAction() {
        return easyRandom.nextObject(AuthzHipAction.AuthzHipActionBuilder.class);
    }

    public static UserAuthConfirmRequest.UserAuthConfirmRequestBuilder userAuthConfirmRequest() {
        return easyRandom.nextObject(UserAuthConfirmRequest.UserAuthConfirmRequestBuilder.class);
    }
}
