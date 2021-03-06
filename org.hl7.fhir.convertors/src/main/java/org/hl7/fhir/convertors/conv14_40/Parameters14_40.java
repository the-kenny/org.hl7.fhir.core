package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Parameters14_40 {

    public static org.hl7.fhir.dstu2016may.model.Parameters convertParameters(org.hl7.fhir.r4.model.Parameters src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Parameters tgt = new org.hl7.fhir.dstu2016may.model.Parameters();
        VersionConvertor_14_40.copyResource(src, tgt);
        if (src.hasParameter()) {
            for (org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent t : src.getParameter()) tgt.addParameter(convertParametersParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Parameters convertParameters(org.hl7.fhir.dstu2016may.model.Parameters src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Parameters tgt = new org.hl7.fhir.r4.model.Parameters();
        VersionConvertor_14_40.copyResource(src, tgt);
        if (src.hasParameter()) {
            for (org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent t : src.getParameter()) tgt.addParameter(convertParametersParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasValue()) {
            tgt.setValue(VersionConvertor_14_40.convertType(src.getValue()));
        }
        if (src.hasResource()) {
            tgt.setResource(VersionConvertor_14_40.convertResource(src.getResource()));
        }
        if (src.hasPart()) {
            for (org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent t : src.getPart()) tgt.addPart(convertParametersParameterComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent convertParametersParameterComponent(org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent tgt = new org.hl7.fhir.dstu2016may.model.Parameters.ParametersParameterComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasValue()) {
            tgt.setValue(VersionConvertor_14_40.convertType(src.getValue()));
        }
        if (src.hasResource()) {
            tgt.setResource(VersionConvertor_14_40.convertResource(src.getResource()));
        }
        if (src.hasPart()) {
            for (org.hl7.fhir.r4.model.Parameters.ParametersParameterComponent t : src.getPart()) tgt.addPart(convertParametersParameterComponent(t));
        }
        return tgt;
    }
}
