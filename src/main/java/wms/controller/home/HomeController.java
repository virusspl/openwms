package wms.controller.home;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import wms.repository.user.UserRepository;

@Controller
public class HomeController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/")
	public String viewWelcomePage(Model model) {

		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);

		model.addAttribute("dateDec", day + "." + month + "." + year);
		model.addAttribute("dateBin",
				Integer.toBinaryString(day) + "." + Integer.toBinaryString(month) + "." + Integer.toBinaryString(year));
		model.addAttribute("dateHex",
				Integer.toHexString(day) + "." + Integer.toHexString(month) + "." + Integer.toHexString(year));
		model.addAttribute("dayOfYearDec", dayOfYear);
		model.addAttribute("dayOfYearBin", Integer.toBinaryString(dayOfYear));
		model.addAttribute("dayOfYearHex", Integer.toHexString(dayOfYear));

		model.addAttribute("text", "$@*&#@*#(");

		return "home/home";
	}
	
	@GetMapping("/info")
	public String viewInfoPage() {
		return "home/info";
	}
	
	@GetMapping("/login")
	public String viewLoginPage() {
		return "home/login";
	}
	
	@GetMapping("/noaccess")
	public String viewNoAccessPage() {
		// TODO based on error page 
		// error page small over menu...
		return "home/noaccess";
	}

	
	
	@GetMapping("/user/exec")
	public String viewExecPage(Model model) {
		return "home/exec";
	}
	
	@GetMapping("/admin/manage")
	public String viewManagePage(Model model) {
		System.out.println(userRepository.findByUsernameIgnoreCase("Manager"));
		return "home/manage";
	}
	
	@GetMapping("/err")
	public String viewErrorPage(Model model) throws Exception {
		throw new Exception("Unknown (Fake) Exception");
	}	
}