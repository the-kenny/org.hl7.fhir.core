package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class MessageHeader10_40 {

    public static org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasTarget()) {
            tgt.setTarget(VersionConvertor_10_40.convertReference(src.getTarget()));
        }
        if (src.hasEndpoint()) {
            tgt.setEndpoint(src.getEndpoint());
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasTarget()) {
            tgt.setTarget(VersionConvertor_10_40.convertReference(src.getTarget()));
        }
        if (src.hasEndpoint()) {
            tgt.setEndpoint(src.getEndpoint());
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageHeader convertMessageHeader(org.hl7.fhir.dstu2.model.MessageHeader src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.MessageHeader tgt = new org.hl7.fhir.r4.model.MessageHeader();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasEvent()) {
            tgt.setEvent(VersionConvertor_10_40.convertCoding(src.getEvent()));
        }
        if (src.hasResponse()) {
            tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
        }
        if (src.hasSource()) {
            tgt.setSource(convertMessageSourceComponent(src.getSource()));
        }
        if (src.hasDestination()) {
            for (org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent t : src.getDestination()) tgt.addDestination(convertMessageDestinationComponent(t));
        }
        if (src.hasEnterer()) {
            tgt.setEnterer(VersionConvertor_10_40.convertReference(src.getEnterer()));
        }
        if (src.hasAuthor()) {
            tgt.setAuthor(VersionConvertor_10_40.convertReference(src.getAuthor()));
        }
        if (src.hasResponsible()) {
            tgt.setResponsible(VersionConvertor_10_40.convertReference(src.getResponsible()));
        }
        if (src.hasReason()) {
            tgt.setReason(VersionConvertor_10_40.convertCodeableConcept(src.getReason()));
        }
        if (src.hasData()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getData()) tgt.addFocus(VersionConvertor_10_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MessageHeader convertMessageHeader(org.hl7.fhir.r4.model.MessageHeader src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MessageHeader tgt = new org.hl7.fhir.dstu2.model.MessageHeader();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasEventCoding())
            tgt.setEvent(VersionConvertor_10_40.convertCoding(src.getEventCoding()));
        if (src.hasResponse()) {
            tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
        }
        if (src.hasSource()) {
            tgt.setSource(convertMessageSourceComponent(src.getSource()));
        }
        if (src.hasDestination()) {
            for (org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent t : src.getDestination()) tgt.addDestination(convertMessageDestinationComponent(t));
        }
        if (src.hasEnterer()) {
            tgt.setEnterer(VersionConvertor_10_40.convertReference(src.getEnterer()));
        }
        if (src.hasAuthor()) {
            tgt.setAuthor(VersionConvertor_10_40.convertReference(src.getAuthor()));
        }
        if (src.hasResponsible()) {
            tgt.setResponsible(VersionConvertor_10_40.convertReference(src.getResponsible()));
        }
        if (src.hasReason()) {
            tgt.setReason(VersionConvertor_10_40.convertCodeableConcept(src.getReason()));
        }
        if (src.hasFocus()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getFocus()) tgt.addData(VersionConvertor_10_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasIdentifier()) {
            tgt.setIdentifier(src.getIdentifier());
        }
        if (src.hasCode()) {
            tgt.setCode(convertResponseType(src.getCode()));
        }
        if (src.hasDetails()) {
            tgt.setDetails(VersionConvertor_10_40.convertReference(src.getDetails()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasIdentifier()) {
            tgt.setIdentifier(src.getIdentifier());
        }
        if (src.hasCode()) {
            tgt.setCode(convertResponseType(src.getCode()));
        }
        if (src.hasDetails()) {
            tgt.setDetails(VersionConvertor_10_40.convertReference(src.getDetails()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasSoftware()) {
            tgt.setSoftware(src.getSoftware());
        }
        if (src.hasVersion()) {
            tgt.setVersion(src.getVersion());
        }
        if (src.hasContact()) {
            tgt.setContact(VersionConvertor_10_40.convertContactPoint(src.getContact()));
        }
        if (src.hasEndpoint()) {
            tgt.setEndpoint(src.getEndpoint());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasSoftware()) {
            tgt.setSoftware(src.getSoftware());
        }
        if (src.hasVersion()) {
            tgt.setVersion(src.getVersion());
        }
        if (src.hasContact()) {
            tgt.setContact(VersionConvertor_10_40.convertContactPoint(src.getContact()));
        }
        if (src.hasEndpoint()) {
            tgt.setEndpoint(src.getEndpoint());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MessageHeader.ResponseType convertResponseType(org.hl7.fhir.r4.model.MessageHeader.ResponseType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OK:
                return org.hl7.fhir.dstu2.model.MessageHeader.ResponseType.OK;
            case TRANSIENTERROR:
                return org.hl7.fhir.dstu2.model.MessageHeader.ResponseType.TRANSIENTERROR;
            case FATALERROR:
                return org.hl7.fhir.dstu2.model.MessageHeader.ResponseType.FATALERROR;
            default:
                return org.hl7.fhir.dstu2.model.MessageHeader.ResponseType.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.MessageHeader.ResponseType convertResponseType(org.hl7.fhir.dstu2.model.MessageHeader.ResponseType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OK:
                return org.hl7.fhir.r4.model.MessageHeader.ResponseType.OK;
            case TRANSIENTERROR:
                return org.hl7.fhir.r4.model.MessageHeader.ResponseType.TRANSIENTERROR;
            case FATALERROR:
                return org.hl7.fhir.r4.model.MessageHeader.ResponseType.FATALERROR;
            default:
                return org.hl7.fhir.r4.model.MessageHeader.ResponseType.NULL;
        }
    }
}
