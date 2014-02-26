package coreservlets;

import javax.servlet.http.*;
import org.apache.struts.action.*;

public class RegisterAction1 extends Action {
  public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response)
      throws Exception {
    return(mapping.findForward("success"));
  }
}
