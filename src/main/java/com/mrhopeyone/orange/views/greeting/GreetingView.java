package com.mrhopeyone.orange.views.greeting;

import org.springframework.beans.factory.annotation.Value;

import com.mrhopeyone.orange.views.MainLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

import jakarta.annotation.PostConstruct;

@PageTitle("Greeting")
@Route(value = "greeting", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class GreetingView extends VerticalLayout {


	@Value("${app.mainmessage}")
	String theMessage;
	@Value("${app.secretpassword}")
	String thePassword;
	
	@Value("${spring.application.name}")
	private String appName;
	@Value("${spring.profiles.active: default}")
	private String activeProfile;
	
    private Span name;
    private Span profiles;
    private Span messageText;
    private Span appPassword;

    @PostConstruct
    public void setupView() {
    	
        name = new Span("spring.application.name: " + appName);
        profiles = new Span("spring.profiles.active: " + activeProfile);
        messageText = new Span("app.mainmessage: " + theMessage);
        appPassword = new Span("app.secretpassword: " + thePassword);

        setMargin(true);

        add(name, profiles, messageText, appPassword);
    }

}
