package org.hl7.fhir.convertors;

/*-
 * #%L
 * org.hl7.fhir.convertors
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.hl7.fhir.convertors.conv10_40.*;
import org.hl7.fhir.dstu2.model.CodeableConcept;
import org.hl7.fhir.dstu2.model.Parameters;
import org.hl7.fhir.dstu2.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.dstu2.model.Reference;
import org.hl7.fhir.dstu2.utils.ToolingExtensions;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.conformance.ProfileUtilities;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r4.model.CodeSystem.ConceptDefinitionDesignationComponent;
import org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent;
import org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent;
import org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingDiscriminatorComponent;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent;
import org.hl7.fhir.r4.model.TerminologyCapabilities;
import org.hl7.fhir.r4.model.Timing.EventTiming;
import org.hl7.fhir.r4.terminologies.CodeSystemUtilities;
import org.hl7.fhir.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.

  Redistribution and use in source and binary forms, with or without modification,
  are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, this
     list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
     this list of conditions and the following disclaimer in the documentation
     and/or other materials provided with the distribution.
 * Neither the name of HL7 nor the names of its contributors may be used to
     endorse or promote products derived from this software without specific
     prior written permission.

  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
  POSSIBILITY OF SUCH DAMAGE.

 */
public class VersionConvertor_10_40 {

    static public List<String> CANONICAL_URLS = new ArrayList<String>();

    static {
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/11179-permitted-value-conceptmap");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/11179-permitted-value-valueset");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/codesystem-map");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/cqif-library");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-allowedUnits");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-inheritedExtensibleValueSet");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-maxValueSet");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/elementdefinition-minValueSet");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/event-instantiatesCanonical");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-allowedProfile");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-deMap");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-sourceStructureMap");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-targetStructureMap");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/questionnaire-unit-valueSet");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-map");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-supplement");
        CANONICAL_URLS.add("http://hl7.org/fhir/StructureDefinition/valueset-system");
    }

    public static void copyElement(org.hl7.fhir.dstu2.model.Element src, org.hl7.fhir.r4.model.Element tgt) throws FHIRException {
        tgt.setId(src.getId());
        for (org.hl7.fhir.dstu2.model.Extension e : src.getExtension()) {
            tgt.addExtension(convertExtension(e));
        }
    }

    public static void copyElement(org.hl7.fhir.r4.model.Element src, org.hl7.fhir.dstu2.model.Element tgt) throws FHIRException {
        tgt.setId(src.getId());
        for (org.hl7.fhir.r4.model.Extension e : src.getExtension()) {
            tgt.addExtension(convertExtension(e));
        }
    }

    public static void copyElement(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.dstu2.model.Element tgt) throws FHIRException {
        tgt.setId(src.getId());
        for (org.hl7.fhir.r4.model.Extension e : src.getExtension()) {
            tgt.addExtension(convertExtension(e));
        }
    }

    public static org.hl7.fhir.r4.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.dstu2.model.Base64BinaryType src) throws FHIRException {
        org.hl7.fhir.r4.model.Base64BinaryType tgt = new org.hl7.fhir.r4.model.Base64BinaryType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Base64BinaryType convertBase64Binary(org.hl7.fhir.r4.model.Base64BinaryType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.Base64BinaryType tgt = new org.hl7.fhir.dstu2.model.Base64BinaryType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.BooleanType convertBoolean(org.hl7.fhir.dstu2.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.r4.model.BooleanType tgt = new org.hl7.fhir.r4.model.BooleanType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.BooleanType convertBoolean(org.hl7.fhir.r4.model.BooleanType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.BooleanType tgt = new org.hl7.fhir.dstu2.model.BooleanType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeType convertCode(org.hl7.fhir.dstu2.model.CodeType src) throws FHIRException {
        org.hl7.fhir.r4.model.CodeType tgt = new org.hl7.fhir.r4.model.CodeType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CodeType convertCode(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.CodeType tgt = new org.hl7.fhir.dstu2.model.CodeType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UriType convertCodeToUri(org.hl7.fhir.dstu2.model.CodeType src) throws FHIRException {
        org.hl7.fhir.r4.model.UriType tgt = new org.hl7.fhir.r4.model.UriType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CodeType convertUriToCode(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.CodeType tgt = new org.hl7.fhir.dstu2.model.CodeType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateType tgt = new org.hl7.fhir.r4.model.DateType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateType convertDate(org.hl7.fhir.dstu2.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateType tgt = new org.hl7.fhir.r4.model.DateType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateTimeType convertDateToDateTime(org.hl7.fhir.dstu2.model.DateType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateTimeType tgt = new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDateTimeToDate(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DateType tgt = new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.r4.model.DateType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DateType tgt = new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateType convertDate(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DateType tgt = new org.hl7.fhir.dstu2.model.DateType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateTimeType convertDateTime(org.hl7.fhir.dstu2.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateTimeType tgt = new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DateTimeType convertDateTime(org.hl7.fhir.r4.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DateTimeType tgt = new org.hl7.fhir.dstu2.model.DateTimeType(src.getValueAsString());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DecimalType convertDecimal(org.hl7.fhir.dstu2.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.r4.model.DecimalType tgt = new org.hl7.fhir.r4.model.DecimalType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DecimalType convertDecimal(org.hl7.fhir.r4.model.DecimalType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.DecimalType tgt = new org.hl7.fhir.dstu2.model.DecimalType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.IdType convertId(org.hl7.fhir.dstu2.model.IdType src) throws FHIRException {
        org.hl7.fhir.r4.model.IdType tgt = new org.hl7.fhir.r4.model.IdType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.IdType convertId(org.hl7.fhir.r4.model.IdType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.IdType tgt = new org.hl7.fhir.dstu2.model.IdType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InstantType convertInstant(org.hl7.fhir.dstu2.model.InstantType src) throws FHIRException {
        org.hl7.fhir.r4.model.InstantType tgt = new org.hl7.fhir.r4.model.InstantType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.InstantType convertInstant(org.hl7.fhir.r4.model.InstantType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.InstantType tgt = new org.hl7.fhir.dstu2.model.InstantType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.IntegerType convertInteger(org.hl7.fhir.dstu2.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.r4.model.IntegerType tgt = new org.hl7.fhir.r4.model.IntegerType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.IntegerType convertInteger(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.IntegerType tgt = new org.hl7.fhir.dstu2.model.IntegerType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MarkdownType convertMarkdown(org.hl7.fhir.dstu2.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.r4.model.MarkdownType tgt = new org.hl7.fhir.r4.model.MarkdownType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MarkdownType convertMarkdown(org.hl7.fhir.r4.model.MarkdownType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.MarkdownType tgt = new org.hl7.fhir.dstu2.model.MarkdownType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OidType convertOid(org.hl7.fhir.dstu2.model.OidType src) throws FHIRException {
        org.hl7.fhir.r4.model.OidType tgt = new org.hl7.fhir.r4.model.OidType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OidType convertOid(org.hl7.fhir.r4.model.OidType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.OidType tgt = new org.hl7.fhir.dstu2.model.OidType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PositiveIntType convertPositiveInt(org.hl7.fhir.dstu2.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.r4.model.PositiveIntType tgt = new org.hl7.fhir.r4.model.PositiveIntType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.PositiveIntType convertPositiveInt(org.hl7.fhir.r4.model.PositiveIntType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.PositiveIntType tgt = new org.hl7.fhir.dstu2.model.PositiveIntType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.StringType convertString(org.hl7.fhir.dstu2.model.StringType src) throws FHIRException {
        org.hl7.fhir.r4.model.StringType tgt = new org.hl7.fhir.r4.model.StringType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.StringType convertString(org.hl7.fhir.r4.model.StringType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.StringType tgt = new org.hl7.fhir.dstu2.model.StringType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TimeType convertTime(org.hl7.fhir.dstu2.model.TimeType src) throws FHIRException {
        org.hl7.fhir.r4.model.TimeType tgt = new org.hl7.fhir.r4.model.TimeType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TimeType convertTime(org.hl7.fhir.r4.model.TimeType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.TimeType tgt = new org.hl7.fhir.dstu2.model.TimeType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.dstu2.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.r4.model.UnsignedIntType tgt = new org.hl7.fhir.r4.model.UnsignedIntType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.UnsignedIntType convertUnsignedInt(org.hl7.fhir.r4.model.UnsignedIntType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.UnsignedIntType tgt = new org.hl7.fhir.dstu2.model.UnsignedIntType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UriType convertUri(org.hl7.fhir.dstu2.model.UriType src) throws FHIRException {
        org.hl7.fhir.r4.model.UriType tgt = new org.hl7.fhir.r4.model.UriType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.UriType convertUri(org.hl7.fhir.r4.model.UriType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.UriType tgt = new org.hl7.fhir.dstu2.model.UriType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.UuidType convertUuid(org.hl7.fhir.dstu2.model.UuidType src) throws FHIRException {
        org.hl7.fhir.r4.model.UuidType tgt = new org.hl7.fhir.r4.model.UuidType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.UuidType convertUuid(org.hl7.fhir.r4.model.UuidType src) throws FHIRException {
        org.hl7.fhir.dstu2.model.UuidType tgt = new org.hl7.fhir.dstu2.model.UuidType(src.getValue());
        copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Extension convertExtension(org.hl7.fhir.dstu2.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
        copyElement(src, tgt);
        tgt.setUrl(src.getUrl());
        if (src.hasValue())
            if (CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.dstu2.model.Reference)
                tgt.setValue(convertReferenceToCanonical((Reference) src.getValue()));
            else
                tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Extension convertExtension(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Extension tgt = new org.hl7.fhir.dstu2.model.Extension();
        copyElement(src, tgt);
        tgt.setUrl(src.getUrl());
        if (src.hasValue())
            if (CANONICAL_URLS.contains(src.getUrl()) && src.getValue() instanceof org.hl7.fhir.r4.model.CanonicalType)
                tgt.setValue(convertCanonicalToReference((CanonicalType) src.getValue()));
            else
                tgt.setValue(convertType(src.getValue()));
        tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Narrative convertNarrative(org.hl7.fhir.dstu2.model.Narrative src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Narrative tgt = new org.hl7.fhir.r4.model.Narrative();
        copyElement(src, tgt);
        tgt.setStatus(convertNarrativeStatus(src.getStatus()));
        tgt.setDiv(src.getDiv());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Narrative convertNarrative(org.hl7.fhir.r4.model.Narrative src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Narrative tgt = new org.hl7.fhir.dstu2.model.Narrative();
        copyElement(src, tgt);
        tgt.setStatus(convertNarrativeStatus(src.getStatus()));
        tgt.setDiv(src.getDiv());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Narrative.NarrativeStatus convertNarrativeStatus(org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GENERATED:
                return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.GENERATED;
            case EXTENSIONS:
                return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.EXTENSIONS;
            case ADDITIONAL:
                return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.ADDITIONAL;
            case EMPTY:
                return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.EMPTY;
            default:
                return org.hl7.fhir.r4.model.Narrative.NarrativeStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus convertNarrativeStatus(org.hl7.fhir.r4.model.Narrative.NarrativeStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GENERATED:
                return org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.GENERATED;
            case EXTENSIONS:
                return org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.EXTENSIONS;
            case ADDITIONAL:
                return org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.ADDITIONAL;
            case EMPTY:
                return org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.EMPTY;
            default:
                return org.hl7.fhir.dstu2.model.Narrative.NarrativeStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Annotation convertAnnotation(org.hl7.fhir.dstu2.model.Annotation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Annotation tgt = new org.hl7.fhir.r4.model.Annotation();
        copyElement(src, tgt);
        tgt.setAuthor(convertType(src.getAuthor()));
        tgt.setTime(src.getTime());
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Annotation convertAnnotation(org.hl7.fhir.r4.model.Annotation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Annotation tgt = new org.hl7.fhir.dstu2.model.Annotation();
        copyElement(src, tgt);
        tgt.setAuthor(convertType(src.getAuthor()));
        tgt.setTime(src.getTime());
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Attachment convertAttachment(org.hl7.fhir.dstu2.model.Attachment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Attachment tgt = new org.hl7.fhir.r4.model.Attachment();
        copyElement(src, tgt);
        tgt.setContentType(src.getContentType());
        tgt.setLanguage(src.getLanguage());
        tgt.setData(src.getData());
        tgt.setUrl(src.getUrl());
        tgt.setSize(src.getSize());
        tgt.setHash(src.getHash());
        tgt.setTitle(src.getTitle());
        tgt.setCreation(src.getCreation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Attachment convertAttachment(org.hl7.fhir.r4.model.Attachment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Attachment tgt = new org.hl7.fhir.dstu2.model.Attachment();
        copyElement(src, tgt);
        tgt.setContentType(src.getContentType());
        tgt.setLanguage(src.getLanguage());
        tgt.setData(src.getData());
        tgt.setUrl(src.getUrl());
        tgt.setSize(src.getSize());
        tgt.setHash(src.getHash());
        tgt.setTitle(src.getTitle());
        tgt.setCreation(src.getCreation());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.dstu2.model.CodeableConcept src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CodeableConcept convertCodeableConcept(org.hl7.fhir.r4.model.CodeableConcept src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.CodeableConcept tgt = new org.hl7.fhir.dstu2.model.CodeableConcept();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Coding t : src.getCoding()) tgt.addCoding(convertCoding(t));
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Coding convertCoding(org.hl7.fhir.dstu2.model.Coding src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Coding tgt = new org.hl7.fhir.r4.model.Coding();
        copyElement(src, tgt);
        tgt.setSystem(src.getSystem());
        tgt.setVersion(src.getVersion());
        tgt.setCode(src.getCode());
        tgt.setDisplay(src.getDisplay());
        tgt.setUserSelected(src.getUserSelected());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Coding convertCoding(org.hl7.fhir.r4.model.Coding src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Coding tgt = new org.hl7.fhir.dstu2.model.Coding();
        copyElement(src, tgt);
        tgt.setSystem(src.getSystem());
        tgt.setVersion(src.getVersion());
        tgt.setCode(src.getCode());
        tgt.setDisplay(src.getDisplay());
        tgt.setUserSelected(src.getUserSelected());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Identifier convertIdentifier(org.hl7.fhir.dstu2.model.Identifier src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Identifier tgt = new org.hl7.fhir.r4.model.Identifier();
        copyElement(src, tgt);
        tgt.setUse(convertIdentifierUse(src.getUse()));
        tgt.setType(convertCodeableConcept(src.getType()));
        tgt.setSystem(src.getSystem());
        tgt.setValue(src.getValue());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        tgt.setAssigner(convertReference(src.getAssigner()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Identifier convertIdentifier(org.hl7.fhir.r4.model.Identifier src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Identifier tgt = new org.hl7.fhir.dstu2.model.Identifier();
        copyElement(src, tgt);
        if (src.hasUse())
            tgt.setUse(convertIdentifierUse(src.getUse()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasValue())
            tgt.setValue(src.getValue());
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasAssigner())
            tgt.setAssigner(convertReference(src.getAssigner()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Identifier.IdentifierUse convertIdentifierUse(org.hl7.fhir.dstu2.model.Identifier.IdentifierUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case USUAL:
                return org.hl7.fhir.r4.model.Identifier.IdentifierUse.USUAL;
            case OFFICIAL:
                return org.hl7.fhir.r4.model.Identifier.IdentifierUse.OFFICIAL;
            case TEMP:
                return org.hl7.fhir.r4.model.Identifier.IdentifierUse.TEMP;
            case SECONDARY:
                return org.hl7.fhir.r4.model.Identifier.IdentifierUse.SECONDARY;
            default:
                return org.hl7.fhir.r4.model.Identifier.IdentifierUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Identifier.IdentifierUse convertIdentifierUse(org.hl7.fhir.r4.model.Identifier.IdentifierUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case USUAL:
                return org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.USUAL;
            case OFFICIAL:
                return org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.OFFICIAL;
            case TEMP:
                return org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.TEMP;
            case SECONDARY:
                return org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.SECONDARY;
            default:
                return org.hl7.fhir.dstu2.model.Identifier.IdentifierUse.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Period convertPeriod(org.hl7.fhir.dstu2.model.Period src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Period tgt = new org.hl7.fhir.r4.model.Period();
        copyElement(src, tgt);
        tgt.setStart(src.getStart());
        tgt.setEnd(src.getEnd());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Period convertPeriod(org.hl7.fhir.r4.model.Period src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Period tgt = new org.hl7.fhir.dstu2.model.Period();
        copyElement(src, tgt);
        tgt.setStart(src.getStart());
        tgt.setEnd(src.getEnd());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Quantity convertQuantity(org.hl7.fhir.dstu2.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Quantity tgt = new org.hl7.fhir.r4.model.Quantity();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Quantity convertQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Quantity tgt = new org.hl7.fhir.dstu2.model.Quantity();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Quantity.QuantityComparator convertQuantityComparator(org.hl7.fhir.dstu2.model.Quantity.QuantityComparator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case LESS_THAN:
                return org.hl7.fhir.r4.model.Quantity.QuantityComparator.LESS_THAN;
            case LESS_OR_EQUAL:
                return org.hl7.fhir.r4.model.Quantity.QuantityComparator.LESS_OR_EQUAL;
            case GREATER_OR_EQUAL:
                return org.hl7.fhir.r4.model.Quantity.QuantityComparator.GREATER_OR_EQUAL;
            case GREATER_THAN:
                return org.hl7.fhir.r4.model.Quantity.QuantityComparator.GREATER_THAN;
            default:
                return org.hl7.fhir.r4.model.Quantity.QuantityComparator.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Quantity.QuantityComparator convertQuantityComparator(org.hl7.fhir.r4.model.Quantity.QuantityComparator src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case LESS_THAN:
                return org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.LESS_THAN;
            case LESS_OR_EQUAL:
                return org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.LESS_OR_EQUAL;
            case GREATER_OR_EQUAL:
                return org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.GREATER_OR_EQUAL;
            case GREATER_THAN:
                return org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.GREATER_THAN;
            default:
                return org.hl7.fhir.dstu2.model.Quantity.QuantityComparator.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Range convertRange(org.hl7.fhir.dstu2.model.Range src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Range tgt = new org.hl7.fhir.r4.model.Range();
        copyElement(src, tgt);
        tgt.setLow(convertSimpleQuantity(src.getLow()));
        tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Range convertRange(org.hl7.fhir.r4.model.Range src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Range tgt = new org.hl7.fhir.dstu2.model.Range();
        copyElement(src, tgt);
        tgt.setLow(convertSimpleQuantity(src.getLow()));
        tgt.setHigh(convertSimpleQuantity(src.getHigh()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Ratio convertRatio(org.hl7.fhir.dstu2.model.Ratio src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Ratio tgt = new org.hl7.fhir.r4.model.Ratio();
        copyElement(src, tgt);
        tgt.setNumerator(convertQuantity(src.getNumerator()));
        tgt.setDenominator(convertQuantity(src.getDenominator()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Ratio convertRatio(org.hl7.fhir.r4.model.Ratio src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Ratio tgt = new org.hl7.fhir.dstu2.model.Ratio();
        copyElement(src, tgt);
        tgt.setNumerator(convertQuantity(src.getNumerator()));
        tgt.setDenominator(convertQuantity(src.getDenominator()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Reference convertReference(org.hl7.fhir.dstu2.model.Reference src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
        copyElement(src, tgt);
        tgt.setReference(src.getReference());
        tgt.setDisplay(src.getDisplay());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Reference convertReference(org.hl7.fhir.r4.model.Reference src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Reference tgt = new org.hl7.fhir.dstu2.model.Reference();
        copyElement(src, tgt);
        tgt.setReference(src.getReference());
        tgt.setDisplay(src.getDisplay());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SampledData convertSampledData(org.hl7.fhir.dstu2.model.SampledData src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.SampledData tgt = new org.hl7.fhir.r4.model.SampledData();
        copyElement(src, tgt);
        tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
        tgt.setPeriod(src.getPeriod());
        tgt.setFactor(src.getFactor());
        tgt.setLowerLimit(src.getLowerLimit());
        tgt.setUpperLimit(src.getUpperLimit());
        tgt.setDimensions(src.getDimensions());
        tgt.setData(src.getData());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SampledData convertSampledData(org.hl7.fhir.r4.model.SampledData src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SampledData tgt = new org.hl7.fhir.dstu2.model.SampledData();
        copyElement(src, tgt);
        tgt.setOrigin(convertSimpleQuantity(src.getOrigin()));
        tgt.setPeriod(src.getPeriod());
        tgt.setFactor(src.getFactor());
        tgt.setLowerLimit(src.getLowerLimit());
        tgt.setUpperLimit(src.getUpperLimit());
        tgt.setDimensions(src.getDimensions());
        tgt.setData(src.getData());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Signature convertSignature(org.hl7.fhir.dstu2.model.Signature src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Signature tgt = new org.hl7.fhir.r4.model.Signature();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        tgt.setWhen(src.getWhen());
        if (src.hasWhoUriType())
            tgt.setWho(new org.hl7.fhir.r4.model.Reference(src.getWhoUriType().getValue()));
        else
            tgt.setWho(convertReference(src.getWhoReference()));
        tgt.setSigFormat(src.getContentType());
        tgt.setData(src.getBlob());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Signature convertSignature(org.hl7.fhir.r4.model.Signature src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Signature tgt = new org.hl7.fhir.dstu2.model.Signature();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        tgt.setWhen(src.getWhen());
        tgt.setWho(convertType(src.getWho()));
        tgt.setContentType(src.getSigFormat());
        tgt.setBlob(src.getData());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Address convertAddress(org.hl7.fhir.dstu2.model.Address src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Address tgt = new org.hl7.fhir.r4.model.Address();
        copyElement(src, tgt);
        tgt.setUse(convertAddressUse(src.getUse()));
        tgt.setType(convertAddressType(src.getType()));
        tgt.setText(src.getText());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
        tgt.setCity(src.getCity());
        tgt.setDistrict(src.getDistrict());
        tgt.setState(src.getState());
        tgt.setPostalCode(src.getPostalCode());
        tgt.setCountry(src.getCountry());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Address convertAddress(org.hl7.fhir.r4.model.Address src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Address tgt = new org.hl7.fhir.dstu2.model.Address();
        copyElement(src, tgt);
        tgt.setUse(convertAddressUse(src.getUse()));
        tgt.setType(convertAddressType(src.getType()));
        tgt.setText(src.getText());
        for (org.hl7.fhir.r4.model.StringType t : src.getLine()) tgt.addLine(t.getValue());
        tgt.setCity(src.getCity());
        tgt.setDistrict(src.getDistrict());
        tgt.setState(src.getState());
        tgt.setPostalCode(src.getPostalCode());
        tgt.setCountry(src.getCountry());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Address.AddressUse convertAddressUse(org.hl7.fhir.dstu2.model.Address.AddressUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HOME:
                return org.hl7.fhir.r4.model.Address.AddressUse.HOME;
            case WORK:
                return org.hl7.fhir.r4.model.Address.AddressUse.WORK;
            case TEMP:
                return org.hl7.fhir.r4.model.Address.AddressUse.TEMP;
            case OLD:
                return org.hl7.fhir.r4.model.Address.AddressUse.OLD;
            default:
                return org.hl7.fhir.r4.model.Address.AddressUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Address.AddressUse convertAddressUse(org.hl7.fhir.r4.model.Address.AddressUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HOME:
                return org.hl7.fhir.dstu2.model.Address.AddressUse.HOME;
            case WORK:
                return org.hl7.fhir.dstu2.model.Address.AddressUse.WORK;
            case TEMP:
                return org.hl7.fhir.dstu2.model.Address.AddressUse.TEMP;
            case OLD:
                return org.hl7.fhir.dstu2.model.Address.AddressUse.OLD;
            default:
                return org.hl7.fhir.dstu2.model.Address.AddressUse.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Address.AddressType convertAddressType(org.hl7.fhir.dstu2.model.Address.AddressType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case POSTAL:
                return org.hl7.fhir.r4.model.Address.AddressType.POSTAL;
            case PHYSICAL:
                return org.hl7.fhir.r4.model.Address.AddressType.PHYSICAL;
            case BOTH:
                return org.hl7.fhir.r4.model.Address.AddressType.BOTH;
            default:
                return org.hl7.fhir.r4.model.Address.AddressType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Address.AddressType convertAddressType(org.hl7.fhir.r4.model.Address.AddressType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case POSTAL:
                return org.hl7.fhir.dstu2.model.Address.AddressType.POSTAL;
            case PHYSICAL:
                return org.hl7.fhir.dstu2.model.Address.AddressType.PHYSICAL;
            case BOTH:
                return org.hl7.fhir.dstu2.model.Address.AddressType.BOTH;
            default:
                return org.hl7.fhir.dstu2.model.Address.AddressType.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ContactPoint convertContactPoint(org.hl7.fhir.dstu2.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactPoint tgt = new org.hl7.fhir.r4.model.ContactPoint();
        copyElement(src, tgt);
        tgt.setSystem(convertContactPointSystem(src.getSystem()));
        tgt.setValue(src.getValue());
        tgt.setUse(convertContactPointUse(src.getUse()));
        if (src.hasRank())
            tgt.setRank(src.getRank());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ContactPoint convertContactPoint(org.hl7.fhir.r4.model.ContactPoint src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ContactPoint tgt = new org.hl7.fhir.dstu2.model.ContactPoint();
        copyElement(src, tgt);
        if (src.hasSystem())
            tgt.setSystem(convertContactPointSystem(src.getSystem()));
        tgt.setValue(src.getValue());
        tgt.setUse(convertContactPointUse(src.getUse()));
        tgt.setRank(src.getRank());
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem convertContactPointSystem(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PHONE:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.PHONE;
            case FAX:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.FAX;
            case EMAIL:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.EMAIL;
            case PAGER:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.PAGER;
            case OTHER:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.OTHER;
            default:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem convertContactPointSystem(org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PHONE:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.PHONE;
            case FAX:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.FAX;
            case EMAIL:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.EMAIL;
            case PAGER:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.PAGER;
            case OTHER:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.OTHER;
            case URL:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.OTHER;
            default:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointSystem.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ContactPoint.ContactPointUse convertContactPointUse(org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HOME:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.HOME;
            case WORK:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.WORK;
            case TEMP:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.TEMP;
            case OLD:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.OLD;
            case MOBILE:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.MOBILE;
            default:
                return org.hl7.fhir.r4.model.ContactPoint.ContactPointUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse convertContactPointUse(org.hl7.fhir.r4.model.ContactPoint.ContactPointUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HOME:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.HOME;
            case WORK:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.WORK;
            case TEMP:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.TEMP;
            case OLD:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.OLD;
            case MOBILE:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.MOBILE;
            default:
                return org.hl7.fhir.dstu2.model.ContactPoint.ContactPointUse.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition convertElementDefinition(org.hl7.fhir.dstu2.model.ElementDefinition src, List<String> slicePaths, List<org.hl7.fhir.dstu2.model.ElementDefinition> context, int pos) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition tgt = new org.hl7.fhir.r4.model.ElementDefinition();
        copyElement(src, tgt);
        tgt.setPath(src.getPath());
        for (org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation> t : src.getRepresentation()) copyElement(t, tgt.addRepresentationElement().setValue(convertPropertyRepresentation(t.getValue())));
        if (src.hasName()) {
            if (slicePaths.contains(src.getPath()))
                tgt.setSliceName(src.getName());
            tgt.setId(src.getName());
        }
        if (src.hasLabel())
            tgt.setLabel(src.getLabel());
        for (org.hl7.fhir.dstu2.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
        if (src.hasSlicing())
            tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing(), context, pos));
        if (src.hasShort())
            tgt.setShort(src.getShort());
        if (src.hasDefinition())
            tgt.setDefinition(src.getDefinition());
        if (src.hasComments())
            tgt.setComment(src.getComments());
        if (src.hasRequirements())
            tgt.setRequirements(src.getRequirements());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMax(src.getMax());
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasNameReference())
            tgt.setContentReference("#" + src.getNameReference());
        for (org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent t : src.getType()) convertElementDefinitionTypeComponent(t, tgt.getType());
        if (src.hasDefaultValue())
            tgt.setDefaultValue(convertType(src.getDefaultValue()));
        if (src.hasMeaningWhenMissing())
            tgt.setMeaningWhenMissing(src.getMeaningWhenMissing());
        if (src.hasFixed())
            tgt.setFixed(convertType(src.getFixed()));
        if (src.hasPattern())
            tgt.setPattern(convertType(src.getPattern()));
        if (src.hasExample())
            tgt.addExample().setLabel("General").setValue(convertType(src.getExample()));
        if (src.hasMinValue())
            tgt.setMinValue(convertType(src.getMinValue()));
        if (src.hasMaxValue())
            tgt.setMaxValue(convertType(src.getMaxValue()));
        if (src.hasMaxLength())
            tgt.setMaxLength(src.getMaxLength());
        for (org.hl7.fhir.dstu2.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
        for (org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
        if (src.hasMustSupport())
            tgt.setMustSupport(src.getMustSupport());
        if (src.hasIsModifier())
            tgt.setIsModifier(src.getIsModifier());
        if (tgt.getIsModifier()) {
            String reason = org.hl7.fhir.dstu2.utils.ToolingExtensions.readStringExtension(src, VersionConvertorConstants.MODIFIER_REASON_EXTENSION);
            if (Utilities.noString(reason))
                reason = VersionConvertorConstants.MODIFIER_REASON_LEGACY;
            tgt.setIsModifierReason(reason);
        }
        if (src.hasIsSummary())
            tgt.setIsSummary(src.getIsSummary());
        if (src.hasBinding())
            tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
        for (org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        if (!tgt.hasId())
            tgt.setId(tgt.getPath());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition convertElementDefinition(org.hl7.fhir.r4.model.ElementDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition tgt = new org.hl7.fhir.dstu2.model.ElementDefinition();
        copyElement(src, tgt);
        tgt.setPath(src.getPath());
        for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation> t : src.getRepresentation()) copyElement(t, tgt.addRepresentationElement().setValue(convertPropertyRepresentation(t.getValue())));
        if (src.hasSliceName())
            tgt.setName(src.getSliceName());
        else
            tgt.setName(src.getId());
        tgt.setLabel(src.getLabel());
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(convertCoding(t));
        if (src.hasSlicing())
            tgt.setSlicing(convertElementDefinitionSlicingComponent(src.getSlicing()));
        tgt.setShort(src.getShort());
        tgt.setDefinition(src.getDefinition());
        tgt.setComments(src.getComment());
        tgt.setRequirements(src.getRequirements());
        for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        tgt.setMin(src.getMin());
        tgt.setMax(src.getMax());
        if (src.hasBase())
            tgt.setBase(convertElementDefinitionBaseComponent(src.getBase()));
        if (src.hasContentReference())
            tgt.setNameReference(src.getContentReference().substring(1));
        for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : src.getType()) convertElementDefinitionTypeComponent(t, tgt.getType());
        tgt.setDefaultValue(convertType(src.getDefaultValue()));
        tgt.setMeaningWhenMissing(src.getMeaningWhenMissing());
        tgt.setFixed(convertType(src.getFixed()));
        tgt.setPattern(convertType(src.getPattern()));
        if (src.hasExample())
            tgt.setExample(convertType(src.getExampleFirstRep().getValue()));
        tgt.setMinValue(convertType(src.getMinValue()));
        tgt.setMaxValue(convertType(src.getMaxValue()));
        tgt.setMaxLength(src.getMaxLength());
        for (org.hl7.fhir.r4.model.IdType t : src.getCondition()) tgt.addCondition(t.getValue());
        for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent t : src.getConstraint()) tgt.addConstraint(convertElementDefinitionConstraintComponent(t));
        tgt.setMustSupport(src.getMustSupport());
        tgt.setIsModifier(src.getIsModifier());
        if (src.hasIsModifierReason() && !VersionConvertorConstants.MODIFIER_REASON_LEGACY.equals(src.getIsModifierReason()))
            org.hl7.fhir.dstu2.utils.ToolingExtensions.setStringExtension(tgt, VersionConvertorConstants.MODIFIER_REASON_EXTENSION, src.getIsModifierReason());
        tgt.setIsSummary(src.getIsSummary());
        if (src.hasBinding())
            tgt.setBinding(convertElementDefinitionBindingComponent(src.getBinding()));
        for (org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent t : src.getMapping()) tgt.addMapping(convertElementDefinitionMappingComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation convertPropertyRepresentation(org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case XMLATTR:
                return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.XMLATTR;
            default:
                return org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation convertPropertyRepresentation(org.hl7.fhir.r4.model.ElementDefinition.PropertyRepresentation src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case XMLATTR:
                return org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation.XMLATTR;
            default:
                return org.hl7.fhir.dstu2.model.ElementDefinition.PropertyRepresentation.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent src, List<org.hl7.fhir.dstu2.model.ElementDefinition> context, int pos) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        org.hl7.fhir.dstu2.model.ElementDefinition slicingElement = context.get(pos);
        for (org.hl7.fhir.dstu2.model.StringType t : src.getDiscriminator()) {
            boolean isExists = false;
            if (!t.asStringValue().contains("@")) {
                int slices = 0;
                boolean existsSlicePresent = false;
                boolean notExistsSlicePresent = false;
                String existsPath = slicingElement.getPath() + "." + t.asStringValue();
                for (int i = pos + 1; i < context.size(); i++) {
                    org.hl7.fhir.dstu2.model.ElementDefinition e = context.get(i);
                    if (e.getPath().equals(slicingElement.getPath()))
                        slices++;
                    else if (!e.getPath().startsWith(slicingElement.getPath() + "."))
                        break;
                    else if (e.getPath().equals(existsPath)) {
                        if (e.hasMin() && e.getMin() > 0)
                            existsSlicePresent = true;
                        else if (e.hasMax() && e.getMax().equals("0"))
                            notExistsSlicePresent = true;
                    }
                }
                isExists = (slices == 2 && existsSlicePresent && notExistsSlicePresent) || (slices == 1 && existsSlicePresent != notExistsSlicePresent);
            }
            tgt.addDiscriminator(ProfileUtilities.interpretR2Discriminator(t.getValue(), isExists));
        }
        tgt.setDescription(src.getDescription());
        tgt.setOrdered(src.getOrdered());
        tgt.setRules(convertSlicingRules(src.getRules()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent convertElementDefinitionSlicingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionSlicingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionSlicingComponent();
        copyElement(src, tgt);
        for (ElementDefinitionSlicingDiscriminatorComponent t : src.getDiscriminator()) tgt.addDiscriminator(ProfileUtilities.buildR2Discriminator(t));
        tgt.setDescription(src.getDescription());
        tgt.setOrdered(src.getOrdered());
        tgt.setRules(convertSlicingRules(src.getRules()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.SlicingRules convertSlicingRules(org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CLOSED:
                return org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.CLOSED;
            case OPEN:
                return org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.OPEN;
            case OPENATEND:
                return org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.OPENATEND;
            default:
                return org.hl7.fhir.r4.model.ElementDefinition.SlicingRules.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules convertSlicingRules(org.hl7.fhir.r4.model.ElementDefinition.SlicingRules src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CLOSED:
                return org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.CLOSED;
            case OPEN:
                return org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.OPEN;
            case OPENATEND:
                return org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.OPENATEND;
            default:
                return org.hl7.fhir.dstu2.model.ElementDefinition.SlicingRules.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent();
        copyElement(src, tgt);
        tgt.setPath(src.getPath());
        tgt.setMin(src.getMin());
        tgt.setMax(src.getMax());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent convertElementDefinitionBaseComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBaseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBaseComponent();
        copyElement(src, tgt);
        tgt.setPath(src.getPath());
        tgt.setMin(src.getMin());
        tgt.setMax(src.getMax());
        return tgt;
    }

    public static void convertElementDefinitionTypeComponent(org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
        if (src == null)
            return;
        org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent tgt = null;
        for (org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent t : list) if (t.getCode().equals(src.getCode()))
            tgt = t;
        if (tgt == null) {
            tgt = new org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent();
            list.add(tgt);
            copyElement(src, tgt);
            tgt.setCode(src.getCode());
        }
        if (tgt.hasTarget()) {
            for (org.hl7.fhir.dstu2.model.UriType u : src.getProfile()) tgt.addTargetProfile(u.getValue());
        } else {
            for (org.hl7.fhir.dstu2.model.UriType u : src.getProfile()) tgt.addProfile(u.getValue());
        }
        for (org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode> t : src.getAggregation()) {
            org.hl7.fhir.r4.model.ElementDefinition.AggregationMode a = convertAggregationMode(t.getValue());
            if (!tgt.hasAggregation(a))
                copyElement(t, tgt.addAggregationElement().setValue(a));
        }
    }

    public static void convertElementDefinitionTypeComponent(org.hl7.fhir.r4.model.ElementDefinition.TypeRefComponent src, List<org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent> list) throws FHIRException {
        if (src == null)
            return;
        org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.TypeRefComponent();
        copyElement(src, tgt);
        tgt.setCode(src.getCode());
        list.add(tgt);
        if (src.hasTarget()) {
            for (org.hl7.fhir.r4.model.UriType u : src.getTargetProfile()) {
                tgt.addProfile(u.getValue());
            }
        } else {
            for (org.hl7.fhir.r4.model.UriType u : src.getProfile()) {
                tgt.addProfile(u.getValue());
            }
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.AggregationMode convertAggregationMode(org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CONTAINED:
                return org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.CONTAINED;
            case REFERENCED:
                return org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.REFERENCED;
            case BUNDLED:
                return org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.BUNDLED;
            default:
                return org.hl7.fhir.r4.model.ElementDefinition.AggregationMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode convertAggregationMode(org.hl7.fhir.r4.model.ElementDefinition.AggregationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CONTAINED:
                return org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.CONTAINED;
            case REFERENCED:
                return org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.REFERENCED;
            case BUNDLED:
                return org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.BUNDLED;
            default:
                return org.hl7.fhir.dstu2.model.ElementDefinition.AggregationMode.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent();
        copyElement(src, tgt);
        tgt.setKey(src.getKey());
        tgt.setRequirements(src.getRequirements());
        tgt.setSeverity(convertConstraintSeverity(src.getSeverity()));
        tgt.setHuman(src.getHuman());
        tgt.setExpression(ToolingExtensions.readStringExtension(src, ToolingExtensions.EXT_EXPRESSION));
        tgt.setXpath(src.getXpath());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent convertElementDefinitionConstraintComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionConstraintComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionConstraintComponent();
        copyElement(src, tgt);
        tgt.setKey(src.getKey());
        tgt.setRequirements(src.getRequirements());
        tgt.setSeverity(convertConstraintSeverity(src.getSeverity()));
        tgt.setHuman(src.getHuman());
        if (src.hasExpression())
            ToolingExtensions.addStringExtension(tgt, ToolingExtensions.EXT_EXPRESSION, src.getExpression());
        tgt.setXpath(src.getXpath());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity convertConstraintSeverity(org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ERROR:
                return org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.ERROR;
            case WARNING:
                return org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.WARNING;
            default:
                return org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity convertConstraintSeverity(org.hl7.fhir.r4.model.ElementDefinition.ConstraintSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ERROR:
                return org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.ERROR;
            case WARNING:
                return org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.WARNING;
            default:
                return org.hl7.fhir.dstu2.model.ElementDefinition.ConstraintSeverity.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt);
        tgt.setStrength(convertBindingStrength(src.getStrength()));
        tgt.setDescription(src.getDescription());
        org.hl7.fhir.r4.model.Type vs = convertType(src.getValueSet());
        if (vs != null) {
            tgt.setValueSet(vs instanceof org.hl7.fhir.r4.model.Reference ? ((org.hl7.fhir.r4.model.Reference) vs).getReference() : vs.primitiveValue());
            tgt.setValueSet(VersionConvertorConstants.refToVS(tgt.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent convertElementDefinitionBindingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionBindingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionBindingComponent();
        copyElement(src, tgt);
        tgt.setStrength(convertBindingStrength(src.getStrength()));
        tgt.setDescription(src.getDescription());
        if (src.hasValueSet()) {
            String vsr = VersionConvertorConstants.vsToRef(src.getValueSet());
            if (vsr != null)
                tgt.setValueSet(new org.hl7.fhir.dstu2.model.UriType(vsr));
            else
                tgt.setValueSet(new org.hl7.fhir.dstu2.model.Reference(src.getValueSet()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Enumerations.BindingStrength convertBindingStrength(org.hl7.fhir.dstu2.model.Enumerations.BindingStrength src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUIRED:
                return org.hl7.fhir.r4.model.Enumerations.BindingStrength.REQUIRED;
            case EXTENSIBLE:
                return org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXTENSIBLE;
            case PREFERRED:
                return org.hl7.fhir.r4.model.Enumerations.BindingStrength.PREFERRED;
            case EXAMPLE:
                return org.hl7.fhir.r4.model.Enumerations.BindingStrength.EXAMPLE;
            default:
                return org.hl7.fhir.r4.model.Enumerations.BindingStrength.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Enumerations.BindingStrength convertBindingStrength(org.hl7.fhir.r4.model.Enumerations.BindingStrength src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUIRED:
                return org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.REQUIRED;
            case EXTENSIBLE:
                return org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.EXTENSIBLE;
            case PREFERRED:
                return org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.PREFERRED;
            case EXAMPLE:
                return org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.EXAMPLE;
            default:
                return org.hl7.fhir.dstu2.model.Enumerations.BindingStrength.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent();
        copyElement(src, tgt);
        tgt.setIdentity(src.getIdentity());
        tgt.setLanguage(src.getLanguage());
        tgt.setMap(src.getMap());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent convertElementDefinitionMappingComponent(org.hl7.fhir.r4.model.ElementDefinition.ElementDefinitionMappingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent tgt = new org.hl7.fhir.dstu2.model.ElementDefinition.ElementDefinitionMappingComponent();
        copyElement(src, tgt);
        tgt.setIdentity(src.getIdentity());
        tgt.setLanguage(src.getLanguage());
        tgt.setMap(src.getMap());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HumanName convertHumanName(org.hl7.fhir.dstu2.model.HumanName src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.HumanName tgt = new org.hl7.fhir.r4.model.HumanName();
        copyElement(src, tgt);
        tgt.setUse(convertNameUse(src.getUse()));
        tgt.setText(src.getText());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getFamily()) tgt.setFamily(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.HumanName convertHumanName(org.hl7.fhir.r4.model.HumanName src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.HumanName tgt = new org.hl7.fhir.dstu2.model.HumanName();
        copyElement(src, tgt);
        tgt.setUse(convertNameUse(src.getUse()));
        tgt.setText(src.getText());
        if (src.hasFamily())
            tgt.addFamily(src.getFamily());
        for (org.hl7.fhir.r4.model.StringType t : src.getGiven()) tgt.addGiven(t.getValue());
        for (org.hl7.fhir.r4.model.StringType t : src.getPrefix()) tgt.addPrefix(t.getValue());
        for (org.hl7.fhir.r4.model.StringType t : src.getSuffix()) tgt.addSuffix(t.getValue());
        tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.HumanName.NameUse convertNameUse(org.hl7.fhir.dstu2.model.HumanName.NameUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case USUAL:
                return org.hl7.fhir.r4.model.HumanName.NameUse.USUAL;
            case OFFICIAL:
                return org.hl7.fhir.r4.model.HumanName.NameUse.OFFICIAL;
            case TEMP:
                return org.hl7.fhir.r4.model.HumanName.NameUse.TEMP;
            case NICKNAME:
                return org.hl7.fhir.r4.model.HumanName.NameUse.NICKNAME;
            case ANONYMOUS:
                return org.hl7.fhir.r4.model.HumanName.NameUse.ANONYMOUS;
            case OLD:
                return org.hl7.fhir.r4.model.HumanName.NameUse.OLD;
            case MAIDEN:
                return org.hl7.fhir.r4.model.HumanName.NameUse.MAIDEN;
            default:
                return org.hl7.fhir.r4.model.HumanName.NameUse.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.HumanName.NameUse convertNameUse(org.hl7.fhir.r4.model.HumanName.NameUse src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case USUAL:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.USUAL;
            case OFFICIAL:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.OFFICIAL;
            case TEMP:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.TEMP;
            case NICKNAME:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.NICKNAME;
            case ANONYMOUS:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.ANONYMOUS;
            case OLD:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.OLD;
            case MAIDEN:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.MAIDEN;
            default:
                return org.hl7.fhir.dstu2.model.HumanName.NameUse.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Meta convertMeta(org.hl7.fhir.dstu2.model.Meta src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Meta tgt = new org.hl7.fhir.r4.model.Meta();
        copyElement(src, tgt);
        tgt.setVersionId(src.getVersionId());
        tgt.setLastUpdated(src.getLastUpdated());
        for (org.hl7.fhir.dstu2.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
        for (org.hl7.fhir.dstu2.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Meta convertMeta(org.hl7.fhir.r4.model.Meta src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Meta tgt = new org.hl7.fhir.dstu2.model.Meta();
        copyElement(src, tgt);
        tgt.setVersionId(src.getVersionId());
        tgt.setLastUpdated(src.getLastUpdated());
        for (org.hl7.fhir.r4.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
        for (org.hl7.fhir.r4.model.Coding t : src.getSecurity()) tgt.addSecurity(convertCoding(t));
        for (org.hl7.fhir.r4.model.Coding t : src.getTag()) tgt.addTag(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Timing convertTiming(org.hl7.fhir.dstu2.model.Timing src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Timing tgt = new org.hl7.fhir.r4.model.Timing();
        copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
        tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
        tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Timing convertTiming(org.hl7.fhir.r4.model.Timing src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Timing tgt = new org.hl7.fhir.dstu2.model.Timing();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.DateTimeType t : src.getEvent()) tgt.addEvent(t.getValue());
        tgt.setRepeat(convertTimingRepeatComponent(src.getRepeat()));
        tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.r4.model.Timing.TimingRepeatComponent();
        copyElement(src, tgt);
        tgt.setBounds(convertType(src.getBounds()));
        tgt.setCount(src.getCount());
        tgt.setDuration(src.getDuration());
        tgt.setDurationMax(src.getDurationMax());
        tgt.setDurationUnit(convertUnitsOfTime(src.getDurationUnits()));
        tgt.setFrequency(src.getFrequency());
        tgt.setFrequencyMax(src.getFrequencyMax());
        tgt.setPeriod(src.getPeriod());
        tgt.setPeriodMax(src.getPeriodMax());
        tgt.setPeriodUnit(convertUnitsOfTime(src.getPeriodUnits()));
        tgt.addWhen(convertEventTiming(src.getWhen()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent convertTimingRepeatComponent(org.hl7.fhir.r4.model.Timing.TimingRepeatComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent tgt = new org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent();
        copyElement(src, tgt);
        tgt.setBounds(convertType(src.getBounds()));
        tgt.setCount(src.getCount());
        tgt.setDuration(src.getDuration());
        tgt.setDurationMax(src.getDurationMax());
        tgt.setDurationUnits(convertUnitsOfTime(src.getDurationUnit()));
        tgt.setFrequency(src.getFrequency());
        tgt.setFrequencyMax(src.getFrequencyMax());
        tgt.setPeriod(src.getPeriod());
        tgt.setPeriodMax(src.getPeriodMax());
        tgt.setPeriodUnits(convertUnitsOfTime(src.getPeriodUnit()));
        for (Enumeration<EventTiming> t : src.getWhen()) tgt.setWhen(convertEventTiming(t.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Timing.UnitsOfTime convertUnitsOfTime(org.hl7.fhir.dstu2.model.Timing.UnitsOfTime src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case S:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.S;
            case MIN:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.MIN;
            case H:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.H;
            case D:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.D;
            case WK:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.WK;
            case MO:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.MO;
            case A:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.A;
            default:
                return org.hl7.fhir.r4.model.Timing.UnitsOfTime.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Timing.UnitsOfTime convertUnitsOfTime(org.hl7.fhir.r4.model.Timing.UnitsOfTime src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case S:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.S;
            case MIN:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.MIN;
            case H:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.H;
            case D:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.D;
            case WK:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.WK;
            case MO:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.MO;
            case A:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.A;
            default:
                return org.hl7.fhir.dstu2.model.Timing.UnitsOfTime.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Timing.EventTiming convertEventTiming(org.hl7.fhir.dstu2.model.Timing.EventTiming src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HS:
                return org.hl7.fhir.r4.model.Timing.EventTiming.HS;
            case WAKE:
                return org.hl7.fhir.r4.model.Timing.EventTiming.WAKE;
            case C:
                return org.hl7.fhir.r4.model.Timing.EventTiming.C;
            case CM:
                return org.hl7.fhir.r4.model.Timing.EventTiming.CM;
            case CD:
                return org.hl7.fhir.r4.model.Timing.EventTiming.CD;
            case CV:
                return org.hl7.fhir.r4.model.Timing.EventTiming.CV;
            case AC:
                return org.hl7.fhir.r4.model.Timing.EventTiming.AC;
            case ACM:
                return org.hl7.fhir.r4.model.Timing.EventTiming.ACM;
            case ACD:
                return org.hl7.fhir.r4.model.Timing.EventTiming.ACD;
            case ACV:
                return org.hl7.fhir.r4.model.Timing.EventTiming.ACV;
            case PC:
                return org.hl7.fhir.r4.model.Timing.EventTiming.PC;
            case PCM:
                return org.hl7.fhir.r4.model.Timing.EventTiming.PCM;
            case PCD:
                return org.hl7.fhir.r4.model.Timing.EventTiming.PCD;
            case PCV:
                return org.hl7.fhir.r4.model.Timing.EventTiming.PCV;
            default:
                return org.hl7.fhir.r4.model.Timing.EventTiming.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Timing.EventTiming convertEventTiming(org.hl7.fhir.r4.model.Timing.EventTiming src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HS:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.HS;
            case WAKE:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.WAKE;
            case C:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.C;
            case CM:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.CM;
            case CD:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.CD;
            case CV:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.CV;
            case AC:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.AC;
            case ACM:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.ACM;
            case ACD:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.ACD;
            case ACV:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.ACV;
            case PC:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.PC;
            case PCM:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.PCM;
            case PCD:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.PCD;
            case PCV:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.PCV;
            default:
                return org.hl7.fhir.dstu2.model.Timing.EventTiming.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Age convertAge(org.hl7.fhir.dstu2.model.Age src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Age tgt = new org.hl7.fhir.r4.model.Age();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Age convertAge(org.hl7.fhir.r4.model.Age src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Age tgt = new org.hl7.fhir.dstu2.model.Age();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Count convertCount(org.hl7.fhir.dstu2.model.Count src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Count tgt = new org.hl7.fhir.r4.model.Count();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Count convertCount(org.hl7.fhir.r4.model.Count src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Count tgt = new org.hl7.fhir.dstu2.model.Count();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Distance convertDistance(org.hl7.fhir.dstu2.model.Distance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Distance tgt = new org.hl7.fhir.r4.model.Distance();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Distance convertDistance(org.hl7.fhir.r4.model.Distance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Distance tgt = new org.hl7.fhir.dstu2.model.Distance();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Duration convertDuration(org.hl7.fhir.dstu2.model.Duration src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Duration tgt = new org.hl7.fhir.r4.model.Duration();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Duration convertDuration(org.hl7.fhir.r4.model.Duration src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Duration tgt = new org.hl7.fhir.dstu2.model.Duration();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Money convertMoney(org.hl7.fhir.dstu2.model.Money src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Money tgt = new org.hl7.fhir.r4.model.Money();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setCurrency(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Money convertMoney(org.hl7.fhir.r4.model.Money src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Money tgt = new org.hl7.fhir.dstu2.model.Money();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setCode(src.getCurrency());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Quantity convertSimpleQuantity(org.hl7.fhir.dstu2.model.SimpleQuantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.SimpleQuantity tgt = new org.hl7.fhir.r4.model.SimpleQuantity();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SimpleQuantity convertSimpleQuantity(org.hl7.fhir.r4.model.Quantity src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SimpleQuantity tgt = new org.hl7.fhir.dstu2.model.SimpleQuantity();
        copyElement(src, tgt);
        tgt.setValue(src.getValue());
        tgt.setComparator(convertQuantityComparator(src.getComparator()));
        tgt.setUnit(src.getUnit());
        tgt.setSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.dstu2.model.Type src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.dstu2.model.Base64BinaryType)
            return convertBase64Binary((org.hl7.fhir.dstu2.model.Base64BinaryType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.BooleanType)
            return convertBoolean((org.hl7.fhir.dstu2.model.BooleanType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.CodeType)
            return convertCode((org.hl7.fhir.dstu2.model.CodeType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DateType)
            return convertDate((org.hl7.fhir.dstu2.model.DateType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DateTimeType)
            return convertDateTime((org.hl7.fhir.dstu2.model.DateTimeType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DecimalType)
            return convertDecimal((org.hl7.fhir.dstu2.model.DecimalType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.IdType)
            return convertId((org.hl7.fhir.dstu2.model.IdType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.InstantType)
            return convertInstant((org.hl7.fhir.dstu2.model.InstantType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.IntegerType)
            return convertInteger((org.hl7.fhir.dstu2.model.IntegerType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.MarkdownType)
            return convertMarkdown((org.hl7.fhir.dstu2.model.MarkdownType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.OidType)
            return convertOid((org.hl7.fhir.dstu2.model.OidType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.PositiveIntType)
            return convertPositiveInt((org.hl7.fhir.dstu2.model.PositiveIntType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.StringType)
            return convertString((org.hl7.fhir.dstu2.model.StringType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.TimeType)
            return convertTime((org.hl7.fhir.dstu2.model.TimeType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.UnsignedIntType)
            return convertUnsignedInt((org.hl7.fhir.dstu2.model.UnsignedIntType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.UriType)
            return convertUri((org.hl7.fhir.dstu2.model.UriType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.UuidType)
            return convertUuid((org.hl7.fhir.dstu2.model.UuidType) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Extension)
            return convertExtension((org.hl7.fhir.dstu2.model.Extension) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Narrative)
            return convertNarrative((org.hl7.fhir.dstu2.model.Narrative) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Annotation)
            return convertAnnotation((org.hl7.fhir.dstu2.model.Annotation) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Attachment)
            return convertAttachment((org.hl7.fhir.dstu2.model.Attachment) src);
        if (src instanceof org.hl7.fhir.dstu2.model.CodeableConcept)
            return convertCodeableConcept((org.hl7.fhir.dstu2.model.CodeableConcept) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Coding)
            return convertCoding((org.hl7.fhir.dstu2.model.Coding) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Identifier)
            return convertIdentifier((org.hl7.fhir.dstu2.model.Identifier) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Period)
            return convertPeriod((org.hl7.fhir.dstu2.model.Period) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Quantity)
            return convertQuantity((org.hl7.fhir.dstu2.model.Quantity) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Range)
            return convertRange((org.hl7.fhir.dstu2.model.Range) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Ratio)
            return convertRatio((org.hl7.fhir.dstu2.model.Ratio) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Reference)
            return convertReference((org.hl7.fhir.dstu2.model.Reference) src);
        if (src instanceof org.hl7.fhir.dstu2.model.SampledData)
            return convertSampledData((org.hl7.fhir.dstu2.model.SampledData) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Signature)
            return convertSignature((org.hl7.fhir.dstu2.model.Signature) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Address)
            return convertAddress((org.hl7.fhir.dstu2.model.Address) src);
        if (src instanceof org.hl7.fhir.dstu2.model.ContactPoint)
            return convertContactPoint((org.hl7.fhir.dstu2.model.ContactPoint) src);
        if (src instanceof org.hl7.fhir.dstu2.model.HumanName)
            return convertHumanName((org.hl7.fhir.dstu2.model.HumanName) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Meta)
            return convertMeta((org.hl7.fhir.dstu2.model.Meta) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Timing)
            return convertTiming((org.hl7.fhir.dstu2.model.Timing) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Age)
            return convertAge((org.hl7.fhir.dstu2.model.Age) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Count)
            return convertCount((org.hl7.fhir.dstu2.model.Count) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Distance)
            return convertDistance((org.hl7.fhir.dstu2.model.Distance) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Duration)
            return convertDuration((org.hl7.fhir.dstu2.model.Duration) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Money)
            return convertMoney((org.hl7.fhir.dstu2.model.Money) src);
        if (src instanceof org.hl7.fhir.dstu2.model.SimpleQuantity)
            return convertSimpleQuantity((org.hl7.fhir.dstu2.model.SimpleQuantity) src);
        throw new FHIRException("Unknown type " + src.fhirType());
    }

    public static org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.r4.model.Base64BinaryType)
            return convertBase64Binary((org.hl7.fhir.r4.model.Base64BinaryType) src);
        if (src instanceof org.hl7.fhir.r4.model.BooleanType)
            return convertBoolean((org.hl7.fhir.r4.model.BooleanType) src);
        if (src instanceof org.hl7.fhir.r4.model.CodeType)
            return convertCode((org.hl7.fhir.r4.model.CodeType) src);
        if (src instanceof org.hl7.fhir.r4.model.DateType)
            return convertDate((org.hl7.fhir.r4.model.DateType) src);
        if (src instanceof org.hl7.fhir.r4.model.DateTimeType)
            return convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src);
        if (src instanceof org.hl7.fhir.r4.model.DecimalType)
            return convertDecimal((org.hl7.fhir.r4.model.DecimalType) src);
        if (src instanceof org.hl7.fhir.r4.model.IdType)
            return convertId((org.hl7.fhir.r4.model.IdType) src);
        if (src instanceof org.hl7.fhir.r4.model.InstantType)
            return convertInstant((org.hl7.fhir.r4.model.InstantType) src);
        if (src instanceof org.hl7.fhir.r4.model.IntegerType)
            return convertInteger((org.hl7.fhir.r4.model.IntegerType) src);
        if (src instanceof org.hl7.fhir.r4.model.MarkdownType)
            return convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src);
        if (src instanceof org.hl7.fhir.r4.model.OidType)
            return convertOid((org.hl7.fhir.r4.model.OidType) src);
        if (src instanceof org.hl7.fhir.r4.model.PositiveIntType)
            return convertPositiveInt((org.hl7.fhir.r4.model.PositiveIntType) src);
        if (src instanceof org.hl7.fhir.r4.model.StringType)
            return convertString((org.hl7.fhir.r4.model.StringType) src);
        if (src instanceof org.hl7.fhir.r4.model.TimeType)
            return convertTime((org.hl7.fhir.r4.model.TimeType) src);
        if (src instanceof org.hl7.fhir.r4.model.UnsignedIntType)
            return convertUnsignedInt((org.hl7.fhir.r4.model.UnsignedIntType) src);
        if (src instanceof org.hl7.fhir.r4.model.UriType)
            return convertUri((org.hl7.fhir.r4.model.UriType) src);
        if (src instanceof org.hl7.fhir.r4.model.UuidType)
            return convertUuid((org.hl7.fhir.r4.model.UuidType) src);
        if (src instanceof org.hl7.fhir.r4.model.Extension)
            return convertExtension((org.hl7.fhir.r4.model.Extension) src);
        if (src instanceof org.hl7.fhir.r4.model.Narrative)
            return convertNarrative((org.hl7.fhir.r4.model.Narrative) src);
        if (src instanceof org.hl7.fhir.r4.model.Annotation)
            return convertAnnotation((org.hl7.fhir.r4.model.Annotation) src);
        if (src instanceof org.hl7.fhir.r4.model.Attachment)
            return convertAttachment((org.hl7.fhir.r4.model.Attachment) src);
        if (src instanceof org.hl7.fhir.r4.model.CodeableConcept)
            return convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src);
        if (src instanceof org.hl7.fhir.r4.model.Coding)
            return convertCoding((org.hl7.fhir.r4.model.Coding) src);
        if (src instanceof org.hl7.fhir.r4.model.Identifier)
            return convertIdentifier((org.hl7.fhir.r4.model.Identifier) src);
        if (src instanceof org.hl7.fhir.r4.model.Period)
            return convertPeriod((org.hl7.fhir.r4.model.Period) src);
        if (src instanceof org.hl7.fhir.r4.model.Quantity)
            return convertQuantity((org.hl7.fhir.r4.model.Quantity) src);
        if (src instanceof org.hl7.fhir.r4.model.Range)
            return convertRange((org.hl7.fhir.r4.model.Range) src);
        if (src instanceof org.hl7.fhir.r4.model.Ratio)
            return convertRatio((org.hl7.fhir.r4.model.Ratio) src);
        if (src instanceof org.hl7.fhir.r4.model.Reference)
            return convertReference((org.hl7.fhir.r4.model.Reference) src);
        if (src instanceof org.hl7.fhir.r4.model.SampledData)
            return convertSampledData((org.hl7.fhir.r4.model.SampledData) src);
        if (src instanceof org.hl7.fhir.r4.model.Signature)
            return convertSignature((org.hl7.fhir.r4.model.Signature) src);
        if (src instanceof org.hl7.fhir.r4.model.Address)
            return convertAddress((org.hl7.fhir.r4.model.Address) src);
        if (src instanceof org.hl7.fhir.r4.model.ContactPoint)
            return convertContactPoint((org.hl7.fhir.r4.model.ContactPoint) src);
        if (src instanceof org.hl7.fhir.r4.model.HumanName)
            return convertHumanName((org.hl7.fhir.r4.model.HumanName) src);
        if (src instanceof org.hl7.fhir.r4.model.Meta)
            return convertMeta((org.hl7.fhir.r4.model.Meta) src);
        if (src instanceof org.hl7.fhir.r4.model.Timing)
            return convertTiming((org.hl7.fhir.r4.model.Timing) src);
        if (src instanceof org.hl7.fhir.r4.model.Age)
            return convertAge((org.hl7.fhir.r4.model.Age) src);
        if (src instanceof org.hl7.fhir.r4.model.Count)
            return convertCount((org.hl7.fhir.r4.model.Count) src);
        if (src instanceof org.hl7.fhir.r4.model.Distance)
            return convertDistance((org.hl7.fhir.r4.model.Distance) src);
        if (src instanceof org.hl7.fhir.r4.model.Duration)
            return convertDuration((org.hl7.fhir.r4.model.Duration) src);
        if (src instanceof org.hl7.fhir.r4.model.Money)
            return convertMoney((org.hl7.fhir.r4.model.Money) src);
        if (src instanceof org.hl7.fhir.r4.model.SimpleQuantity)
            return convertSimpleQuantity((org.hl7.fhir.r4.model.SimpleQuantity) src);
        throw new FHIRException("Unknown type " + src.fhirType());
    }

    static public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
        boolean ok = false;
        for (String s : extensionsToIgnore) if (s.equals(url))
            ok = true;
        return ok;
    }

    public static void copyDomainResource(org.hl7.fhir.dstu2.model.DomainResource src, org.hl7.fhir.r4.model.DomainResource tgt, String... extensionsToIgnore) throws FHIRException {
        copyResource(src, tgt);
        tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.dstu2.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
        for (org.hl7.fhir.dstu2.model.Extension t : src.getExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addExtension(convertExtension(t));
        for (org.hl7.fhir.dstu2.model.Extension t : src.getModifierExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addModifierExtension(convertExtension(t));
    }

    public static void copyDomainResource(org.hl7.fhir.r4.model.DomainResource src, org.hl7.fhir.dstu2.model.DomainResource tgt, String... extensionsToIgnore) throws FHIRException {
        copyResource(src, tgt);
        tgt.setText(convertNarrative(src.getText()));
        for (org.hl7.fhir.r4.model.Resource t : src.getContained()) tgt.addContained(convertResource(t));
        for (org.hl7.fhir.r4.model.Extension t : src.getExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addExtension(convertExtension(t));
        for (org.hl7.fhir.r4.model.Extension t : src.getModifierExtension()) if (!isExemptExtension(t.getUrl(), extensionsToIgnore))
            tgt.addModifierExtension(convertExtension(t));
    }

    public static void copyResource(org.hl7.fhir.dstu2.model.Resource src, org.hl7.fhir.r4.model.Resource tgt) throws FHIRException {
        tgt.setId(src.getId());
        tgt.setMeta(convertMeta(src.getMeta()));
        tgt.setImplicitRules(src.getImplicitRules());
        tgt.setLanguage(src.getLanguage());
    }

    public static void copyResource(org.hl7.fhir.r4.model.Resource src, org.hl7.fhir.dstu2.model.Resource tgt) throws FHIRException {
        tgt.setId(src.getId());
        if (src.hasMeta())
            tgt.setMeta(convertMeta(src.getMeta()));
        if (src.hasImplicitRules())
            tgt.setImplicitRules(src.getImplicitRules());
        if (src.hasLanguage())
            tgt.setLanguage(src.getLanguage());
    }

    public static org.hl7.fhir.r4.model.Enumerations.AdministrativeGender convertAdministrativeGender(org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MALE:
                return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.MALE;
            case FEMALE:
                return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.FEMALE;
            case OTHER:
                return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.OTHER;
            case UNKNOWN:
                return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.UNKNOWN;
            default:
                return org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender convertAdministrativeGender(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MALE:
                return org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.MALE;
            case FEMALE:
                return org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.FEMALE;
            case OTHER:
                return org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.OTHER;
            case UNKNOWN:
                return org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.UNKNOWN;
            default:
                return org.hl7.fhir.dstu2.model.Enumerations.AdministrativeGender.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Enumerations.SearchParamType convertSearchParamType(org.hl7.fhir.dstu2.model.Enumerations.SearchParamType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NUMBER:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.NUMBER;
            case DATE:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.DATE;
            case STRING:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.STRING;
            case TOKEN:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.TOKEN;
            case REFERENCE:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.REFERENCE;
            case COMPOSITE:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.COMPOSITE;
            case QUANTITY:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.QUANTITY;
            case URI:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.URI;
            default:
                return org.hl7.fhir.r4.model.Enumerations.SearchParamType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Enumerations.SearchParamType convertSearchParamType(org.hl7.fhir.r4.model.Enumerations.SearchParamType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NUMBER:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.NUMBER;
            case DATE:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.DATE;
            case STRING:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.STRING;
            case TOKEN:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.TOKEN;
            case REFERENCE:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.REFERENCE;
            case COMPOSITE:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.COMPOSITE;
            case QUANTITY:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.QUANTITY;
            case URI:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.URI;
            default:
                return org.hl7.fhir.dstu2.model.Enumerations.SearchParamType.NULL;
        }
    }

    static public class SourceElementComponentWrapper {

        public SourceElementComponentWrapper(SourceElementComponent comp, String source, String target) {
            super();
            this.source = source;
            this.target = target;
            this.comp = comp;
        }

        public String source;

        public String target;

        public org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent comp;
    }

    public static org.hl7.fhir.r4.model.UsageContext convertCodeableConceptToUsageContext(org.hl7.fhir.dstu2.model.CodeableConcept t) throws FHIRException {
        org.hl7.fhir.r4.model.UsageContext result = new org.hl7.fhir.r4.model.UsageContext();
        result.setValue(convertCodeableConcept(t));
        return result;
    }

    public static org.hl7.fhir.r4.model.Enumerations.PublicationStatus convertConformanceResourceStatus(org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.DRAFT;
            case ACTIVE:
                return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.ACTIVE;
            case RETIRED:
                return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.RETIRED;
            default:
                return org.hl7.fhir.r4.model.Enumerations.PublicationStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus convertConformanceResourceStatus(org.hl7.fhir.r4.model.Enumerations.PublicationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.DRAFT;
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.ACTIVE;
            case RETIRED:
                return org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.RETIRED;
            default:
                return org.hl7.fhir.dstu2.model.Enumerations.ConformanceResourceStatus.NULL;
        }
    }

    static public CanonicalType convertReferenceToCanonical(Reference src) throws FHIRException {
        CanonicalType dst = new CanonicalType(src.getReference());
        copyElement(src, dst);
        return dst;
    }

    static public Reference convertCanonicalToReference(CanonicalType src) throws FHIRException {
        Reference dst = new Reference(src.getValue());
        copyElement(src, dst);
        return dst;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode convertConformanceEventMode(org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SENDER:
                return org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.SENDER;
            case RECEIVER:
                return org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.RECEIVER;
            default:
                return org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode convertConformanceEventMode(org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SENDER:
                return org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode.SENDER;
            case RECEIVER:
                return org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode.RECEIVER;
            default:
                return org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent();
        copyElement(src, tgt);
        tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        tgt.setRef(convertReference(src.getRef()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.r4.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent();
        copyElement(src, tgt);
        tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        tgt.setRef(convertReference(src.getRef()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Reference getPerformer(List<ImmunizationPerformerComponent> practitioner) {
        for (ImmunizationPerformerComponent p : practitioner) {
            if (hasConcept(p.getFunction(), "http://hl7.org/fhir/v2/0443", "AP"))
                return p.getActor();
        }
        return null;
    }

    static public org.hl7.fhir.r4.model.Reference getRequester(List<ImmunizationPerformerComponent> practitioner) {
        for (ImmunizationPerformerComponent p : practitioner) {
            if (hasConcept(p.getFunction(), "http://hl7.org/fhir/v2/0443", "OP"))
                return p.getActor();
        }
        return null;
    }

    static public boolean hasConcept(org.hl7.fhir.r4.model.CodeableConcept cc, String system, String code) {
        for (org.hl7.fhir.r4.model.Coding c : cc.getCoding()) {
            if (system.equals(c.getSystem()) && code.equals(c.getCode()))
                return true;
        }
        return false;
    }

    static public boolean hasConcept(org.hl7.fhir.dstu2.model.CodeableConcept cc, String system, String code) {
        for (org.hl7.fhir.dstu2.model.Coding c : cc.getCoding()) {
            if (system.equals(c.getSystem()) && code.equals(c.getCode()))
                return true;
        }
        return false;
    }

    public static org.hl7.fhir.r4.model.Dosage convertMedicationOrderDosageInstructionComponent(org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
        copyElement(src, tgt);
        tgt.setText(src.getText());
        tgt.setTiming(convertTiming(src.getTiming()));
        tgt.setAsNeeded(convertType(src.getAsNeeded()));
        if (src.hasSiteCodeableConcept())
            tgt.setSite(convertCodeableConcept(src.getSiteCodeableConcept()));
        tgt.setRoute(convertCodeableConcept(src.getRoute()));
        tgt.setMethod(convertCodeableConcept(src.getMethod()));
        if (src.hasDose() || src.hasRate()) {
            DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
            if (src.hasDose())
                dr.setDose(convertType(src.getDose()));
            if (src.hasRate())
                dr.setRate(convertType(src.getRate()));
        }
        tgt.setMaxDosePerPeriod(convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent convertMedicationOrderDosageInstructionComponent(org.hl7.fhir.r4.model.Dosage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent();
        copyElement(src, tgt);
        tgt.setText(src.getText());
        tgt.setTiming(convertTiming(src.getTiming()));
        tgt.setAsNeeded(convertType(src.getAsNeeded()));
        tgt.setSite(convertType(src.getSite()));
        tgt.setRoute(convertCodeableConcept(src.getRoute()));
        tgt.setMethod(convertCodeableConcept(src.getMethod()));
        if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasDose())
            tgt.setDose(convertType(src.getDoseAndRate().get(0).getDose()));
        if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
            tgt.setRate(convertType(src.getDoseAndRate().get(0).getRate()));
        tgt.setMaxDosePerPeriod(convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Slot.SlotStatus convertSlotStatus(org.hl7.fhir.dstu2.model.Slot.SlotStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case BUSY:
                return org.hl7.fhir.r4.model.Slot.SlotStatus.BUSY;
            case FREE:
                return org.hl7.fhir.r4.model.Slot.SlotStatus.FREE;
            case BUSYUNAVAILABLE:
                return org.hl7.fhir.r4.model.Slot.SlotStatus.BUSYUNAVAILABLE;
            case BUSYTENTATIVE:
                return org.hl7.fhir.r4.model.Slot.SlotStatus.BUSYTENTATIVE;
            default:
                return org.hl7.fhir.r4.model.Slot.SlotStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Slot.SlotStatus convertSlotStatus(org.hl7.fhir.r4.model.Slot.SlotStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case BUSY:
                return org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSY;
            case FREE:
                return org.hl7.fhir.dstu2.model.Slot.SlotStatus.FREE;
            case BUSYUNAVAILABLE:
                return org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSYUNAVAILABLE;
            case BUSYTENTATIVE:
                return org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSYTENTATIVE;
            default:
                return org.hl7.fhir.dstu2.model.Slot.SlotStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus convertSupplyRequestStatus(org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUESTED:
                return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.COMPLETED;
            case FAILED:
                return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.CANCELLED;
            case CANCELLED:
                return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.CANCELLED;
            default:
                return org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus convertSupplyRequestStatus(org.hl7.fhir.r4.model.SupplyRequest.SupplyRequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.REQUESTED;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.COMPLETED;
            case CANCELLED:
                return org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.CANCELLED;
            default:
                return org.hl7.fhir.dstu2.model.SupplyRequest.SupplyRequestStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ValueSetCodeSystemComponent convertCodeSystem(org.hl7.fhir.r4.model.CodeSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ValueSetCodeSystemComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ValueSetCodeSystemComponent();
        copyElement(src, tgt);
        tgt.setSystem(src.getUrl());
        tgt.setVersion(src.getVersion());
        tgt.setCaseSensitive(src.getCaseSensitive());
        for (ConceptDefinitionComponent cc : src.getConcept()) tgt.addConcept(convertCodeSystemConcept(src, cc));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent convertCodeSystemConcept(CodeSystem cs, ConceptDefinitionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionComponent();
        copyElement(src, tgt);
        tgt.setAbstract(CodeSystemUtilities.isNotSelectable(cs, src));
        tgt.setCode(src.getCode());
        tgt.setDefinition(src.getDefinition());
        tgt.setDisplay(src.getDisplay());
        for (ConceptDefinitionComponent cc : src.getConcept()) tgt.addConcept(convertCodeSystemConcept(cs, cc));
        for (ConceptDefinitionDesignationComponent cc : src.getDesignation()) tgt.addDesignation(convertCodeSystemDesignation(cc));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent convertCodeSystemDesignation(ConceptDefinitionDesignationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent tgt = new org.hl7.fhir.dstu2.model.ValueSet.ConceptDefinitionDesignationComponent();
        copyElement(src, tgt);
        tgt.setUse(convertCoding(src.getUse()));
        tgt.setLanguage(src.getLanguage());
        tgt.setValue(src.getValue());
        return tgt;
    }

    static public boolean isJurisdiction(CodeableConcept t) {
        return t.hasCoding() && ("http://unstats.un.org/unsd/methods/m49/m49.htm".equals(t.getCoding().get(0).getSystem()) || "urn:iso:std:iso:3166".equals(t.getCoding().get(0).getSystem()) || "https://www.usps.com/".equals(t.getCoding().get(0).getSystem()));
    }

    public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src, VersionConvertorAdvisor40 advisor) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.dstu2.model.Parameters)
            return Parameters10_40.convertParameters((org.hl7.fhir.dstu2.model.Parameters) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Appointment)
            return Appointment10_40.convertAppointment((org.hl7.fhir.dstu2.model.Appointment) src);
        if (src instanceof org.hl7.fhir.dstu2.model.AppointmentResponse)
            return AppointmentResponse10_40.convertAppointmentResponse((org.hl7.fhir.dstu2.model.AppointmentResponse) src);
        if (src instanceof org.hl7.fhir.dstu2.model.AuditEvent)
            return AuditEvent10_40.convertAuditEvent((org.hl7.fhir.dstu2.model.AuditEvent) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Basic)
            return Basic10_40.convertBasic((org.hl7.fhir.dstu2.model.Basic) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Binary)
            return Binary10_40.convertBinary((org.hl7.fhir.dstu2.model.Binary) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Bundle)
            return Bundle10_40.convertBundle((org.hl7.fhir.dstu2.model.Bundle) src);
        if (src instanceof org.hl7.fhir.dstu2.model.CarePlan)
            return CarePlan10_40.convertCarePlan((org.hl7.fhir.dstu2.model.CarePlan) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Communication)
            return Communication10_40.convertCommunication((org.hl7.fhir.dstu2.model.Communication) src);
        if (src instanceof org.hl7.fhir.dstu2.model.CommunicationRequest)
            return CommunicationRequest10_40.convertCommunicationRequest((org.hl7.fhir.dstu2.model.CommunicationRequest) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Composition)
            return Composition10_40.convertComposition((org.hl7.fhir.dstu2.model.Composition) src);
        if (src instanceof org.hl7.fhir.dstu2.model.ConceptMap)
            return ConceptMap10_40.convertConceptMap((org.hl7.fhir.dstu2.model.ConceptMap) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Condition)
            return Condition10_40.convertCondition((org.hl7.fhir.dstu2.model.Condition) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Conformance)
            return Conformance10_40.convertConformance((org.hl7.fhir.dstu2.model.Conformance) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DataElement)
            return DataElement10_40.convertDataElement((org.hl7.fhir.dstu2.model.DataElement) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DetectedIssue)
            return DetectedIssue10_40.convertDetectedIssue((org.hl7.fhir.dstu2.model.DetectedIssue) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DeviceMetric)
            return DeviceMetric10_40.convertDeviceMetric((org.hl7.fhir.dstu2.model.DeviceMetric) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DeviceUseStatement)
            return DeviceUseStatement10_40.convertDeviceUseStatement((org.hl7.fhir.dstu2.model.DeviceUseStatement) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DiagnosticReport)
            return DiagnosticReport10_40.convertDiagnosticReport((org.hl7.fhir.dstu2.model.DiagnosticReport) src);
        if (src instanceof org.hl7.fhir.dstu2.model.DocumentReference)
            return DocumentReference10_40.convertDocumentReference((org.hl7.fhir.dstu2.model.DocumentReference) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Encounter)
            return Encounter10_40.convertEncounter((org.hl7.fhir.dstu2.model.Encounter) src);
        if (src instanceof org.hl7.fhir.dstu2.model.EnrollmentRequest)
            return EnrollmentRequest10_40.convertEnrollmentRequest((org.hl7.fhir.dstu2.model.EnrollmentRequest) src);
        if (src instanceof org.hl7.fhir.dstu2.model.EnrollmentResponse)
            return EnrollmentResponse10_40.convertEnrollmentResponse((org.hl7.fhir.dstu2.model.EnrollmentResponse) src);
        if (src instanceof org.hl7.fhir.dstu2.model.EpisodeOfCare)
            return EpisodeOfCare10_40.convertEpisodeOfCare((org.hl7.fhir.dstu2.model.EpisodeOfCare) src);
        if (src instanceof org.hl7.fhir.dstu2.model.FamilyMemberHistory)
            return FamilyMemberHistory10_40.convertFamilyMemberHistory((org.hl7.fhir.dstu2.model.FamilyMemberHistory) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Flag)
            return Flag10_40.convertFlag((org.hl7.fhir.dstu2.model.Flag) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Group)
            return Group10_40.convertGroup((org.hl7.fhir.dstu2.model.Group) src);
        if (src instanceof org.hl7.fhir.dstu2.model.HealthcareService)
            return HealthcareService10_40.convertHealthcareService((org.hl7.fhir.dstu2.model.HealthcareService) src);
        if (src instanceof org.hl7.fhir.dstu2.model.ImplementationGuide)
            return ImplementationGuide10_40.convertImplementationGuide((org.hl7.fhir.dstu2.model.ImplementationGuide) src);
        if (src instanceof org.hl7.fhir.dstu2.model.List_)
            return List10_40.convertList((org.hl7.fhir.dstu2.model.List_) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Location)
            return Location10_40.convertLocation((org.hl7.fhir.dstu2.model.Location) src);
        if (src instanceof org.hl7.fhir.dstu2.model.MedicationDispense)
            return MedicationDispense10_40.convertMedicationDispense((org.hl7.fhir.dstu2.model.MedicationDispense) src);
        if (src instanceof org.hl7.fhir.dstu2.model.MedicationStatement)
            return MedicationStatement10_40.convertMedicationStatement((org.hl7.fhir.dstu2.model.MedicationStatement) src);
        if (src instanceof org.hl7.fhir.dstu2.model.MessageHeader)
            return MessageHeader10_40.convertMessageHeader((org.hl7.fhir.dstu2.model.MessageHeader) src);
        if (src instanceof org.hl7.fhir.dstu2.model.NamingSystem)
            return NamingSystem10_40.convertNamingSystem((org.hl7.fhir.dstu2.model.NamingSystem) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Observation)
            return Observation10_40.convertObservation((org.hl7.fhir.dstu2.model.Observation) src);
        if (src instanceof org.hl7.fhir.dstu2.model.OperationDefinition)
            return OperationDefinition10_40.convertOperationDefinition((org.hl7.fhir.dstu2.model.OperationDefinition) src);
        if (src instanceof org.hl7.fhir.dstu2.model.OperationOutcome)
            return OperationOutcome10_40.convertOperationOutcome((org.hl7.fhir.dstu2.model.OperationOutcome) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Organization)
            return Organization10_40.convertOrganization((org.hl7.fhir.dstu2.model.Organization) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Patient)
            return Patient10_40.convertPatient((org.hl7.fhir.dstu2.model.Patient) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Person)
            return Person10_40.convertPerson((org.hl7.fhir.dstu2.model.Person) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Practitioner)
            return Practitioner10_40.convertPractitioner((org.hl7.fhir.dstu2.model.Practitioner) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Questionnaire)
            return Questionnaire10_40.convertQuestionnaire((org.hl7.fhir.dstu2.model.Questionnaire) src);
        if (src instanceof org.hl7.fhir.dstu2.model.QuestionnaireResponse)
            return QuestionnaireResponse10_40.convertQuestionnaireResponse((org.hl7.fhir.dstu2.model.QuestionnaireResponse) src);
        if (src instanceof org.hl7.fhir.dstu2.model.RiskAssessment)
            return RiskAssessment10_40.convertRiskAssessment((org.hl7.fhir.dstu2.model.RiskAssessment) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Schedule)
            return Schedule10_40.convertSchedule((org.hl7.fhir.dstu2.model.Schedule) src);
        if (src instanceof org.hl7.fhir.dstu2.model.SearchParameter)
            return SearchParameter10_40.convertSearchParameter((org.hl7.fhir.dstu2.model.SearchParameter) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Slot)
            return Slot10_40.convertSlot((org.hl7.fhir.dstu2.model.Slot) src);
        if (src instanceof org.hl7.fhir.dstu2.model.StructureDefinition)
            return StructureDefinition10_40.convertStructureDefinition((org.hl7.fhir.dstu2.model.StructureDefinition) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Subscription)
            return Subscription10_40.convertSubscription((org.hl7.fhir.dstu2.model.Subscription) src);
        if (src instanceof org.hl7.fhir.dstu2.model.Substance)
            return Substance10_40.convertSubstance((org.hl7.fhir.dstu2.model.Substance) src);
        if (src instanceof org.hl7.fhir.dstu2.model.SupplyDelivery)
            return SupplyDelivery10_40.convertSupplyDelivery((org.hl7.fhir.dstu2.model.SupplyDelivery) src);
        if (src instanceof org.hl7.fhir.dstu2.model.SupplyRequest)
            return SupplyRequest10_40.convertSupplyRequest((org.hl7.fhir.dstu2.model.SupplyRequest) src);
        if (src instanceof org.hl7.fhir.dstu2.model.TestScript)
            return TestScript10_40.convertTestScript((org.hl7.fhir.dstu2.model.TestScript) src);
        if (src instanceof org.hl7.fhir.dstu2.model.ValueSet)
            return ValueSet10_40.convertValueSet((org.hl7.fhir.dstu2.model.ValueSet) src, advisor);
        throw new FHIRException("Unknown resource " + src.fhirType());
    }

    public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src, VersionConvertorAdvisor40 advisor) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        if (src instanceof org.hl7.fhir.r4.model.Parameters)
            return Parameters10_40.convertParameters((org.hl7.fhir.r4.model.Parameters) src);
        if (src instanceof org.hl7.fhir.r4.model.Appointment)
            return Appointment10_40.convertAppointment((org.hl7.fhir.r4.model.Appointment) src);
        if (src instanceof org.hl7.fhir.r4.model.AppointmentResponse)
            return AppointmentResponse10_40.convertAppointmentResponse((org.hl7.fhir.r4.model.AppointmentResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.AuditEvent)
            return AuditEvent10_40.convertAuditEvent((org.hl7.fhir.r4.model.AuditEvent) src);
        if (src instanceof org.hl7.fhir.r4.model.Basic)
            return Basic10_40.convertBasic((org.hl7.fhir.r4.model.Basic) src);
        if (src instanceof org.hl7.fhir.r4.model.Binary)
            return Binary10_40.convertBinary((org.hl7.fhir.r4.model.Binary) src);
        if (src instanceof org.hl7.fhir.r4.model.Bundle)
            return Bundle10_40.convertBundle((org.hl7.fhir.r4.model.Bundle) src, advisor);
        if (src instanceof org.hl7.fhir.r4.model.CarePlan)
            return CarePlan10_40.convertCarePlan((org.hl7.fhir.r4.model.CarePlan) src);
        if (src instanceof org.hl7.fhir.r4.model.Communication)
            return Communication10_40.convertCommunication((org.hl7.fhir.r4.model.Communication) src);
        if (src instanceof org.hl7.fhir.r4.model.CommunicationRequest)
            return CommunicationRequest10_40.convertCommunicationRequest((org.hl7.fhir.r4.model.CommunicationRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.Composition)
            return Composition10_40.convertComposition((org.hl7.fhir.r4.model.Composition) src);
        if (src instanceof org.hl7.fhir.r4.model.ConceptMap)
            return ConceptMap10_40.convertConceptMap((org.hl7.fhir.r4.model.ConceptMap) src);
        if (src instanceof org.hl7.fhir.r4.model.Condition)
            return Condition10_40.convertCondition((org.hl7.fhir.r4.model.Condition) src);
        if (src instanceof org.hl7.fhir.r4.model.CapabilityStatement)
            return Conformance10_40.convertConformance((org.hl7.fhir.r4.model.CapabilityStatement) src);
        if (src instanceof org.hl7.fhir.r4.model.DetectedIssue)
            return DetectedIssue10_40.convertDetectedIssue((org.hl7.fhir.r4.model.DetectedIssue) src);
        if (src instanceof org.hl7.fhir.r4.model.DeviceMetric)
            return DeviceMetric10_40.convertDeviceMetric((org.hl7.fhir.r4.model.DeviceMetric) src);
        if (src instanceof org.hl7.fhir.r4.model.DeviceUseStatement)
            return DeviceUseStatement10_40.convertDeviceUseStatement((org.hl7.fhir.r4.model.DeviceUseStatement) src);
        if (src instanceof org.hl7.fhir.r4.model.DiagnosticReport)
            return DiagnosticReport10_40.convertDiagnosticReport((org.hl7.fhir.r4.model.DiagnosticReport) src);
        if (src instanceof org.hl7.fhir.r4.model.DocumentReference)
            return DocumentReference10_40.convertDocumentReference((org.hl7.fhir.r4.model.DocumentReference) src);
        if (src instanceof org.hl7.fhir.r4.model.Encounter)
            return Encounter10_40.convertEncounter((org.hl7.fhir.r4.model.Encounter) src);
        if (src instanceof org.hl7.fhir.r4.model.EnrollmentRequest)
            return EnrollmentRequest10_40.convertEnrollmentRequest((org.hl7.fhir.r4.model.EnrollmentRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.EnrollmentResponse)
            return EnrollmentResponse10_40.convertEnrollmentResponse((org.hl7.fhir.r4.model.EnrollmentResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.EpisodeOfCare)
            return EpisodeOfCare10_40.convertEpisodeOfCare((org.hl7.fhir.r4.model.EpisodeOfCare) src);
        if (src instanceof org.hl7.fhir.r4.model.FamilyMemberHistory)
            return FamilyMemberHistory10_40.convertFamilyMemberHistory((org.hl7.fhir.r4.model.FamilyMemberHistory) src);
        if (src instanceof org.hl7.fhir.r4.model.Flag)
            return Flag10_40.convertFlag((org.hl7.fhir.r4.model.Flag) src);
        if (src instanceof org.hl7.fhir.r4.model.Group)
            return Group10_40.convertGroup((org.hl7.fhir.r4.model.Group) src);
        if (src instanceof org.hl7.fhir.r4.model.HealthcareService)
            return HealthcareService10_40.convertHealthcareService((org.hl7.fhir.r4.model.HealthcareService) src);
        if (src instanceof org.hl7.fhir.r4.model.ImplementationGuide)
            return ImplementationGuide10_40.convertImplementationGuide((org.hl7.fhir.r4.model.ImplementationGuide) src);
        if (src instanceof org.hl7.fhir.r4.model.ListResource)
            return List10_40.convertList((org.hl7.fhir.r4.model.ListResource) src);
        if (src instanceof org.hl7.fhir.r4.model.Location)
            return Location10_40.convertLocation((org.hl7.fhir.r4.model.Location) src);
        if (src instanceof org.hl7.fhir.r4.model.MedicationDispense)
            return MedicationDispense10_40.convertMedicationDispense((org.hl7.fhir.r4.model.MedicationDispense) src);
        if (src instanceof org.hl7.fhir.r4.model.MedicationStatement)
            return MedicationStatement10_40.convertMedicationStatement((org.hl7.fhir.r4.model.MedicationStatement) src);
        if (src instanceof org.hl7.fhir.r4.model.MessageHeader)
            return MessageHeader10_40.convertMessageHeader((org.hl7.fhir.r4.model.MessageHeader) src);
        if (src instanceof org.hl7.fhir.r4.model.NamingSystem)
            return NamingSystem10_40.convertNamingSystem((org.hl7.fhir.r4.model.NamingSystem) src);
        if (src instanceof org.hl7.fhir.r4.model.Observation)
            return Observation10_40.convertObservation((org.hl7.fhir.r4.model.Observation) src);
        if (src instanceof org.hl7.fhir.r4.model.OperationDefinition)
            return OperationDefinition10_40.convertOperationDefinition((org.hl7.fhir.r4.model.OperationDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.OperationOutcome)
            return OperationOutcome10_40.convertOperationOutcome((org.hl7.fhir.r4.model.OperationOutcome) src);
        if (src instanceof org.hl7.fhir.r4.model.Organization)
            return Organization10_40.convertOrganization((org.hl7.fhir.r4.model.Organization) src);
        if (src instanceof org.hl7.fhir.r4.model.Patient)
            return Patient10_40.convertPatient((org.hl7.fhir.r4.model.Patient) src);
        if (src instanceof org.hl7.fhir.r4.model.Person)
            return Person10_40.convertPerson((org.hl7.fhir.r4.model.Person) src);
        if (src instanceof org.hl7.fhir.r4.model.Practitioner)
            return Practitioner10_40.convertPractitioner((org.hl7.fhir.r4.model.Practitioner) src);
        if (src instanceof org.hl7.fhir.r4.model.Questionnaire)
            return Questionnaire10_40.convertQuestionnaire((org.hl7.fhir.r4.model.Questionnaire) src);
        if (src instanceof org.hl7.fhir.r4.model.QuestionnaireResponse)
            return QuestionnaireResponse10_40.convertQuestionnaireResponse((org.hl7.fhir.r4.model.QuestionnaireResponse) src);
        if (src instanceof org.hl7.fhir.r4.model.RiskAssessment)
            return RiskAssessment10_40.convertRiskAssessment((org.hl7.fhir.r4.model.RiskAssessment) src);
        if (src instanceof org.hl7.fhir.r4.model.Schedule)
            return Schedule10_40.convertSchedule((org.hl7.fhir.r4.model.Schedule) src);
        if (src instanceof org.hl7.fhir.r4.model.SearchParameter)
            return SearchParameter10_40.convertSearchParameter((org.hl7.fhir.r4.model.SearchParameter) src);
        if (src instanceof org.hl7.fhir.r4.model.Slot)
            return Slot10_40.convertSlot((org.hl7.fhir.r4.model.Slot) src);
        if (src instanceof org.hl7.fhir.r4.model.StructureDefinition)
            return StructureDefinition10_40.convertStructureDefinition((org.hl7.fhir.r4.model.StructureDefinition) src);
        if (src instanceof org.hl7.fhir.r4.model.Subscription)
            return Subscription10_40.convertSubscription((org.hl7.fhir.r4.model.Subscription) src);
        if (src instanceof org.hl7.fhir.r4.model.Substance)
            return Substance10_40.convertSubstance((org.hl7.fhir.r4.model.Substance) src);
        if (src instanceof org.hl7.fhir.r4.model.SupplyDelivery)
            return SupplyDelivery10_40.convertSupplyDelivery((org.hl7.fhir.r4.model.SupplyDelivery) src);
        if (src instanceof org.hl7.fhir.r4.model.SupplyRequest)
            return SupplyRequest10_40.convertSupplyRequest((org.hl7.fhir.r4.model.SupplyRequest) src);
        if (src instanceof org.hl7.fhir.r4.model.TestScript)
            return TestScript10_40.convertTestScript((org.hl7.fhir.r4.model.TestScript) src);
        if (src instanceof org.hl7.fhir.r4.model.ValueSet)
            return ValueSet10_40.convertValueSet((org.hl7.fhir.r4.model.ValueSet) src, advisor);
        throw new FHIRException("Unknown resource " + src.fhirType());
    }

    public static TerminologyCapabilities convertTerminologyCapabilities(Parameters src) {
        TerminologyCapabilities res = new TerminologyCapabilities();
        for (ParametersParameterComponent p : src.getParameter()) {
            if (p.getName().equals("system"))
                res.addCodeSystem().setUri(p.getValue().primitiveValue());
        }
        return res;
    }

    public static boolean convertsResource(String rt) {
        return Utilities.existsInList(rt, "Parameters", "Appointment", "AppointmentResponse", "AuditEvent", "Basic", "Binary", "Bundle", "CarePlan", "Communication", "CommunicationRequest", "Composition", "ConceptMap", "Condition", "CapabilityStatement", "DetectedIssue", "DeviceMetric", "DeviceUseStatement", "DiagnosticReport", "DocumentReference", "Encounter", "EnrollmentRequest", "EnrollmentResponse", "EpisodeOfCare", "FamilyMemberHistory", "Flag", "Group", "HealthcareService", "ImplementationGuide", "ListResource", "Location", "MedicationDispense", "MedicationStatement", "MessageHeader", "NamingSystem", "Observation", "OperationDefinition", "OperationOutcome", "Organization", "Patient", "Person", "Practitioner", "Questionnaire", "QuestionnaireResponse", "RiskAssessment", "Schedule", "SearchParameter", "Slot", "StructureDefinition", "Subscription", "Substance", "SupplyDelivery", "SupplyRequest", "TestScript", "ValueSet");
    }

    public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
        return convertResource(src, null);
    }

    public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
        return convertResource(src, null);
    }
}
