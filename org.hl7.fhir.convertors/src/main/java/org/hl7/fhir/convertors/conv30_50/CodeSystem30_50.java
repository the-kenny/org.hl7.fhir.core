package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class CodeSystem30_50 {

    public static org.hl7.fhir.dstu3.model.CodeSystem convertCodeSystem(org.hl7.fhir.r5.model.CodeSystem src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem tgt = new org.hl7.fhir.dstu3.model.CodeSystem();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasCaseSensitive())
            tgt.setCaseSensitive(src.getCaseSensitive());
        if (src.hasValueSet())
            tgt.setValueSet(src.getValueSet());
        if (src.hasHierarchyMeaning())
            tgt.setHierarchyMeaning(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaning()));
        if (src.hasCompositional())
            tgt.setCompositional(src.getCompositional());
        if (src.hasVersionNeeded())
            tgt.setVersionNeeded(src.getVersionNeeded());
        if (src.hasContent())
            tgt.setContent(convertCodeSystemContentMode(src.getContent()));
        if (src.hasCount())
            tgt.setCount(src.getCount());
        if (src.hasFilter()) {
            for (org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        }
        if (src.hasProperty()) {
            for (org.hl7.fhir.r5.model.CodeSystem.PropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem convertCodeSystem(org.hl7.fhir.dstu3.model.CodeSystem src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem tgt = new org.hl7.fhir.r5.model.CodeSystem();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasCaseSensitive())
            tgt.setCaseSensitive(src.getCaseSensitive());
        if (src.hasValueSet())
            tgt.setValueSet(src.getValueSet());
        if (src.hasHierarchyMeaning())
            tgt.setHierarchyMeaning(convertCodeSystemHierarchyMeaning(src.getHierarchyMeaning()));
        if (src.hasCompositional())
            tgt.setCompositional(src.getCompositional());
        if (src.hasVersionNeeded())
            tgt.setVersionNeeded(src.getVersionNeeded());
        if (src.hasContent())
            tgt.setContent(convertCodeSystemContentMode(src.getContent()));
        if (src.hasCount())
            tgt.setCount(src.getCount());
        if (src.hasFilter()) {
            for (org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent t : src.getFilter()) tgt.addFilter(convertCodeSystemFilterComponent(t));
        }
        if (src.hasProperty()) {
            for (org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent t : src.getProperty()) tgt.addProperty(convertPropertyComponent(t));
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode convertCodeSystemContentMode(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOTPRESENT:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.NOTPRESENT;
            case EXAMPLE:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.EXAMPLE;
            case FRAGMENT:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.FRAGMENT;
            case COMPLETE:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.COMPLETE;
            default:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode convertCodeSystemContentMode(org.hl7.fhir.r5.model.CodeSystem.CodeSystemContentMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOTPRESENT:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.NOTPRESENT;
            case EXAMPLE:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.EXAMPLE;
            case FRAGMENT:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.FRAGMENT;
            case COMPLETE:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.COMPLETE;
            default:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemContentMode.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasOperator()) {
            for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CodeSystem.FilterOperator> t : src.getOperator()) VersionConvertor_30_50.copyElement(t, tgt.addOperatorElement().setValue(VersionConvertor_30_50.convertFilterOperator(t.getValue())));
        }
        if (src.hasValue())
            tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent convertCodeSystemFilterComponent(org.hl7.fhir.r5.model.CodeSystem.CodeSystemFilterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemFilterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasOperator()) {
            for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> t : src.getOperator()) VersionConvertor_30_50.copyElement(t, tgt.addOperatorElement().setValue(VersionConvertor_30_50.convertFilterOperator(t.getValue())));
        }
        if (src.hasValue())
            tgt.setValue(src.getValue());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning convertCodeSystemHierarchyMeaning(org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GROUPEDBY:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY;
            case ISA:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.ISA;
            case PARTOF:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.PARTOF;
            case CLASSIFIEDWITH:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH;
            default:
                return org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning convertCodeSystemHierarchyMeaning(org.hl7.fhir.dstu3.model.CodeSystem.CodeSystemHierarchyMeaning src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GROUPEDBY:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.GROUPEDBY;
            case ISA:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.ISA;
            case PARTOF:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.PARTOF;
            case CLASSIFIEDWITH:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.CLASSIFIEDWITH;
            default:
                return org.hl7.fhir.r5.model.CodeSystem.CodeSystemHierarchyMeaning.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        if (src.hasDefinition())
            tgt.setDefinition(src.getDefinition());
        if (src.hasDesignation()) {
            for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        }
        if (src.hasProperty()) {
            for (org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent convertConceptDefinitionComponent(org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        if (src.hasDefinition())
            tgt.setDefinition(src.getDefinition());
        if (src.hasDesignation()) {
            for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent t : src.getDesignation()) tgt.addDesignation(convertConceptDefinitionDesignationComponent(t));
        }
        if (src.hasProperty()) {
            for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent t : src.getProperty()) tgt.addProperty(convertConceptPropertyComponent(t));
        }
        if (src.hasConcept()) {
            for (org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionComponent t : src.getConcept()) tgt.addConcept(convertConceptDefinitionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguage(src.getLanguage());
        if (src.hasUse())
            tgt.setUse(VersionConvertor_30_50.convertCoding(src.getUse()));
        if (src.hasValue())
            tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent convertConceptDefinitionDesignationComponent(org.hl7.fhir.dstu3.model.CodeSystem.ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionDesignationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguage(src.getLanguage());
        if (src.hasUse())
            tgt.setUse(VersionConvertor_30_50.convertCoding(src.getUse()));
        if (src.hasValue())
            tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent convertConceptPropertyComponent(org.hl7.fhir.r5.model.CodeSystem.ConceptPropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.ConceptPropertyComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.r5.model.CodeSystem.PropertyComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasType())
            tgt.setType(convertPropertyType(src.getType()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent convertPropertyComponent(org.hl7.fhir.r5.model.CodeSystem.PropertyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent tgt = new org.hl7.fhir.dstu3.model.CodeSystem.PropertyComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasType())
            tgt.setType(convertPropertyType(src.getType()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.CodeSystem.PropertyType convertPropertyType(org.hl7.fhir.r5.model.CodeSystem.PropertyType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CODE:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.CODE;
            case CODING:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.CODING;
            case STRING:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.STRING;
            case INTEGER:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.INTEGER;
            case BOOLEAN:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.BOOLEAN;
            case DATETIME:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.DATETIME;
            default:
                return org.hl7.fhir.dstu3.model.CodeSystem.PropertyType.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.CodeSystem.PropertyType convertPropertyType(org.hl7.fhir.dstu3.model.CodeSystem.PropertyType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CODE:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.CODE;
            case CODING:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.CODING;
            case STRING:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.STRING;
            case INTEGER:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.INTEGER;
            case BOOLEAN:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.BOOLEAN;
            case DATETIME:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.DATETIME;
            default:
                return org.hl7.fhir.r5.model.CodeSystem.PropertyType.NULL;
        }
    }
}
