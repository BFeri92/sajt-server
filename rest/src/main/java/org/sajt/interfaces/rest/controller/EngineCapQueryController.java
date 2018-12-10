package org.sajt.interfaces.rest.controller;


import org.sajt.service.commandprocessor.factory.NameAwareCommandProcessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("capabilities")
public class EngineCapQueryController {

    private List<NameAwareCommandProcessorFactory> commandProcessorFactories;

    @Autowired
    public EngineCapQueryController(List<NameAwareCommandProcessorFactory> commandProcessorFactories) {
        this.commandProcessorFactories = commandProcessorFactories;
    }

    @GetMapping("commandprocessors")
    public List<String> getAvailableCommandProcessors() {
        return commandProcessorFactories.stream()
                .map(NameAwareCommandProcessorFactory::getProcessableCommandName)
                .collect(Collectors.toList());
    }


}
