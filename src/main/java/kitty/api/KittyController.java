package kitty.api;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/kitty")
public class KittyController {
	
	@GetMapping
	public String showRandomKitty()throws IOException {
		URL url = new URL("https://api.thecatapi.com/v1/images/search");
		InputStreamReader reader = new InputStreamReader(url.openStream());
		Kitty[] kitty = new Gson().fromJson(reader, Kitty[].class);
		return "redirect:" + kitty[0].getUrl().toString();
		
		
	}

}
