package org.hl7.fhir.r5.renderers;

import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.renderers.utils.BaseWrappers.ResourceWrapper;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;

public class RendererFactory {

  public static ResourceRenderer factory(String resourceName, RenderingContext context) {

    if (context.getTemplateProvider() != null) {
      String liquidTemplate = context.getTemplateProvider().findTemplate(context, resourceName);
      if (liquidTemplate != null) {
        return new LiquidRenderer(context, liquidTemplate);
      }
    }

    if ("CodeSystem".equals(resourceName)) {
      return new CodeSystemRenderer(context);
    }
    if ("ValueSet".equals(resourceName)) {
      return new ValueSetRenderer(context);
    }
    if ("ConceptMap".equals(resourceName)) {
      return new ConceptMapRenderer(context);
    }

    if ("CapabilityStatement".equals(resourceName)) {
      return new CapabilityStatementRenderer(context);
    }
    if ("StructureDefinition".equals(resourceName)) {
      return new StructureDefinitionRenderer(context);
    }
    if ("OperationDefinition".equals(resourceName)) {
      return new OperationDefinitionRenderer(context);
    }
    if ("CompartmentDefinition".equals(resourceName)) {
      return new CompartmentDefinitionRenderer(context);
    }
    if ("ImplementationGuide".equals(resourceName)) {
      return new ImplementationGuideRenderer(context);
    }

    if ("Patient".equals(resourceName)) {
      return new PatientRenderer(context);
    }
    if ("Encounter".equals(resourceName)) {
      return new EncounterRenderer(context);
    }
    if ("List".equals(resourceName)) {
      return new ListRenderer(context);
    }
    if ("DiagnosticReport".equals(resourceName)) {
      return new DiagnosticReportRenderer(context);
    }

    if ("Provenance".equals(resourceName)) {
      return new ProvenanceRenderer(context);
    }
    if ("OperationOutcome".equals(resourceName)) {
      return new OperationOutcomeRenderer(context);
    }
    return new ProfileDrivenRenderer(context);    
  }

  public static ResourceRenderer factory(Resource resource, RenderingContext context) {

    if (context.getTemplateProvider() != null && resource instanceof DomainResource) {
      String liquidTemplate = context.getTemplateProvider().findTemplate(context, (DomainResource) resource);
      if (liquidTemplate != null) {
        return new LiquidRenderer(context, liquidTemplate);
      }
    }

    return factory(resource.fhirType(), context);
  }


  public static ResourceRenderer factory(ResourceWrapper resource, RenderingContext context) {
    if (context.getTemplateProvider() != null) {
      String liquidTemplate = context.getTemplateProvider().findTemplate(context, resource.getName());
      if (liquidTemplate != null) {
        return new LiquidRenderer(context, liquidTemplate);
      }
    }

    if ("List".equals(resource.getName())) {
      return new ListRenderer(context);
    }
    if ("DiagnosticReport".equals(resource.getName())) {
      return new DiagnosticReportRenderer(context);
    }

    return new ProfileDrivenRenderer(context);    
  }


}