package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.ContactDetail;
import org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent;

public class Questionnaire10_40 {

    public static org.hl7.fhir.dstu2.model.Questionnaire convertQuestionnaire(org.hl7.fhir.r4.model.Questionnaire src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Questionnaire tgt = new org.hl7.fhir.dstu2.model.Questionnaire();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        }
        if (src.hasVersion()) {
            tgt.setVersion(src.getVersion());
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertQuestionnaireStatus(src.getStatus()));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher()) {
            tgt.setPublisher(src.getPublisher());
        }
        if (src.hasContact()) {
            for (ContactDetail t : src.getContact()) for (org.hl7.fhir.r4.model.ContactPoint t1 : t.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t1));
        }
        org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent root = tgt.getGroup();
        if (src.hasTitle()) {
            root.setTitle(src.getTitle());
        }
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) {
            root.addConcept(VersionConvertor_10_40.convertCoding(t));
        }
        if (src.hasSubjectType()) {
            for (org.hl7.fhir.r4.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        }
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) if (t.getType() == org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.GROUP)
            root.addGroup(convertQuestionnaireGroupComponent(t));
        else
            root.addQuestion(convertQuestionnaireQuestionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire convertQuestionnaire(org.hl7.fhir.dstu2.model.Questionnaire src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Questionnaire tgt = new org.hl7.fhir.r4.model.Questionnaire();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        tgt.setVersion(src.getVersion());
        tgt.setStatus(convertQuestionnaireStatus(src.getStatus()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addContact(convertQuestionnaireContactComponent(t));
        org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent root = src.getGroup();
        tgt.setTitle(root.getTitle());
        for (org.hl7.fhir.dstu2.model.Coding t : root.getConcept()) tgt.addCode(VersionConvertor_10_40.convertCoding(t));
        for (org.hl7.fhir.dstu2.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        tgt.addItem(convertQuestionnaireGroupComponent(root));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertQuestionnaireContactComponent(org.hl7.fhir.dstu2.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(src));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent convertQuestionnaireGroupComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent tgt = new org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLinkId()) {
            tgt.setLinkId(src.getLinkId());
        }
        if (src.hasCode()) {
            for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addConcept(VersionConvertor_10_40.convertCoding(t));
        }
        if (src.hasText()) {
            tgt.setText(src.getText());
        }
        if (src.hasRequired()) {
            tgt.setRequired(src.getRequired());
        }
        if (src.hasRepeats()) {
            tgt.setRepeats(src.getRepeats());
        }
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) if (t.getType() == org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.GROUP)
            tgt.addGroup(convertQuestionnaireGroupComponent(t));
        else
            tgt.addQuestion(convertQuestionnaireQuestionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireGroupComponent(org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLinkId()) {
            tgt.setLinkId(src.getLinkId());
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.dstu2.model.Coding t : src.getConcept()) tgt.addCode(VersionConvertor_10_40.convertCoding(t));
        }
        if (src.hasText()) {
            tgt.setText(src.getText());
        }
        tgt.setType(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.GROUP);
        if (src.hasRequired()) {
            tgt.setRequired(src.getRequired());
        }
        if (src.hasRepeats()) {
            tgt.setRepeats(src.getRepeats());
        }
        if (src.hasGroup()) {
            for (org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent t : src.getGroup()) tgt.addItem(convertQuestionnaireGroupComponent(t));
        }
        if (src.hasQuestion()) {
            for (org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent t : src.getQuestion()) tgt.addItem(convertQuestionnaireQuestionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat convertQuestionnaireItemType(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case BOOLEAN:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.BOOLEAN;
            case DECIMAL:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.DECIMAL;
            case INTEGER:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.INTEGER;
            case DATE:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.DATE;
            case DATETIME:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.DATETIME;
            case TIME:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.TIME;
            case STRING:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.STRING;
            case TEXT:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.TEXT;
            case URL:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.URL;
            case CHOICE:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.CHOICE;
            case OPENCHOICE:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.OPENCHOICE;
            case ATTACHMENT:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.ATTACHMENT;
            case REFERENCE:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.REFERENCE;
            case QUANTITY:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.QUANTITY;
            default:
                return org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent convertQuestionnaireQuestionComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent tgt = new org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLinkId()) {
            tgt.setLinkId(src.getLinkId());
        }
        if (src.hasCode()) {
            for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addConcept(VersionConvertor_10_40.convertCoding(t));
        }
        if (src.hasText()) {
            tgt.setText(src.getText());
        }
        if (src.hasType()) {
            tgt.setType(convertQuestionnaireItemType(src.getType()));
        }
        if (src.hasRequired()) {
            tgt.setRequired(src.getRequired());
        }
        if (src.hasRepeats()) {
            tgt.setRepeats(src.getRepeats());
        }
        if (src.hasAnswerValueSetElement()) {
            tgt.setOptions(VersionConvertor_10_40.convertCanonicalToReference(src.getAnswerValueSetElement()));
        }
        for (QuestionnaireItemAnswerOptionComponent t : src.getAnswerOption()) if (t.hasValueCoding())
            try {
                tgt.addOption(VersionConvertor_10_40.convertCoding(t.getValueCoding()));
            } catch (org.hl7.fhir.exceptions.FHIRException e) {
                throw new FHIRException(e);
            }
        if (src.hasItem()) {
            for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addGroup(convertQuestionnaireGroupComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireQuestionComponent(org.hl7.fhir.dstu2.model.Questionnaire.QuestionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLinkId()) {
            tgt.setLinkId(src.getLinkId());
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.dstu2.model.Coding t : src.getConcept()) tgt.addCode(VersionConvertor_10_40.convertCoding(t));
        }
        if (src.hasText()) {
            tgt.setText(src.getText());
        }
        if (src.hasType()) {
            tgt.setType(convertQuestionnaireQuestionType(src.getType()));
        }
        if (src.hasRequired()) {
            tgt.setRequired(src.getRequired());
        }
        if (src.hasRepeats()) {
            tgt.setRepeats(src.getRepeats());
        }
        if (src.hasOptions()) {
            tgt.setAnswerValueSetElement(VersionConvertor_10_40.convertReferenceToCanonical(src.getOptions()));
        }
        if (src.hasOption()) {
            for (org.hl7.fhir.dstu2.model.Coding t : src.getOption()) tgt.addAnswerOption().setValue(VersionConvertor_10_40.convertCoding(t));
        }
        if (src.hasGroup()) {
            for (org.hl7.fhir.dstu2.model.Questionnaire.GroupComponent t : src.getGroup()) tgt.addItem(convertQuestionnaireGroupComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType convertQuestionnaireQuestionType(org.hl7.fhir.dstu2.model.Questionnaire.AnswerFormat src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case BOOLEAN:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.BOOLEAN;
            case DECIMAL:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DECIMAL;
            case INTEGER:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.INTEGER;
            case DATE:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DATE;
            case DATETIME:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DATETIME;
            case INSTANT:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DATETIME;
            case TIME:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.TIME;
            case STRING:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.STRING;
            case TEXT:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.TEXT;
            case URL:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.URL;
            case CHOICE:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.CHOICE;
            case OPENCHOICE:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.OPENCHOICE;
            case ATTACHMENT:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.ATTACHMENT;
            case REFERENCE:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.REFERENCE;
            case QUANTITY:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.QUANTITY;
            default:
                return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.NULL;
        }
    }

    static public org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus convertQuestionnaireStatus(org.hl7.fhir.r4.model.Enumerations.PublicationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus.DRAFT;
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus.PUBLISHED;
            case RETIRED:
                return org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus.RETIRED;
            default:
                return org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Enumerations.PublicationStatus convertQuestionnaireStatus(org.hl7.fhir.dstu2.model.Questionnaire.QuestionnaireStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.DRAFT;
            case PUBLISHED:
                return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.ACTIVE;
            case RETIRED:
                return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.RETIRED;
            default:
                return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.NULL;
        }
    }
}
