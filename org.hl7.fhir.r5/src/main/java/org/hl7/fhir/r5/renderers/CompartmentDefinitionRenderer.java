package org.hl7.fhir.r5.renderers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.model.DomainResource;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.CompartmentDefinition;
import org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent;
import org.hl7.fhir.r5.renderers.utils.RenderingContext;
import org.hl7.fhir.r5.renderers.utils.Resolver.ResourceContext;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.utilities.xhtml.XhtmlParser;

public class CompartmentDefinitionRenderer extends ResourceRenderer {

  public CompartmentDefinitionRenderer(RenderingContext context) {
    super(context);
  }

  public CompartmentDefinitionRenderer(RenderingContext context, ResourceContext rcontext) {
    super(context, rcontext);
  }
  
  public boolean render(XhtmlNode x, DomainResource dr) throws FHIRFormatError, DefinitionException, IOException {
    return render(x, (CompartmentDefinition) dr);
  }

  public boolean render(XhtmlNode x, CompartmentDefinition cpd) throws FHIRFormatError, DefinitionException, IOException {
    StringBuilder in = new StringBuilder();
    StringBuilder out = new StringBuilder();
    for (CompartmentDefinitionResourceComponent cc: cpd.getResource()) {
      CommaSeparatedStringBuilder rules = new CommaSeparatedStringBuilder();
      if (!cc.hasParam()) {
        out.append(" <li><a href=\"").append(cc.getCode().toLowerCase()).append(".html\">").append(cc.getCode()).append("</a></li>\r\n");
      } else if (!rules.equals("{def}")) {
        for (StringType p : cc.getParam())
          rules.append(p.asStringValue());
        in.append(" <tr><td><a href=\"").append(cc.getCode().toLowerCase()).append(".html\">").append(cc.getCode()).append("</a></td><td>").append(rules.toString()).append("</td></tr>\r\n");
      }
    }
    XhtmlNode xn;
    xn = new XhtmlParser().parseFragment("<div><p>\r\nThe following resources may be in this compartment:\r\n</p>\r\n" +
        "<table class=\"grid\">\r\n"+
        " <tr><td><b>Resource</b></td><td><b>Inclusion Criteria</b></td></tr>\r\n"+
        in.toString()+
        "</table>\r\n"+
        "<p>\r\nA resource is in this compartment if the nominated search parameter (or chain) refers to the patient resource that defines the compartment.\r\n</p>\r\n" +
        "<p>\r\n\r\n</p>\r\n" +
        "<p>\r\nThe following resources are never in this compartment:\r\n</p>\r\n" +
        "<ul>\r\n"+
        out.toString()+
        "</ul></div>\r\n");
    x.getChildNodes().addAll(xn.getChildNodes());
    return true;
  }

  public void describe(XhtmlNode x, CompartmentDefinition cd) {
    x.tx(display(cd));
  }

  public String display(CompartmentDefinition cd) {
    return cd.present();
  }

  @Override
  public String display(DomainResource r) throws UnsupportedEncodingException, IOException {
    return ((CompartmentDefinition) r).present();
  }

}
