package org.sajt.interfaces.rest.controller;

import org.sajt.api.request.WorldCreationRequest;
import org.sajt.api.world.World;
import org.sajt.interfaces.rest.exception.WorldNotFoundException;
import org.sajt.service.WorldContainerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "worlds")
public class WorldManagementController {

    private WorldContainerManager worldContainerManager;

    @Autowired
    public WorldManagementController(WorldContainerManager worldContainerManager) {
        this.worldContainerManager = worldContainerManager;
    }

    @GetMapping
    public Set<String> getWorlds() {
        return worldContainerManager.getWorldNames();
    }

    @PostMapping
    public void createWorld(@RequestBody WorldCreationRequest request) {
        worldContainerManager.createWorld(request);
    }

    @GetMapping("/{worldName}")
    public World getWorld(@RequestParam String worldName) throws WorldNotFoundException {
        return worldContainerManager.getWorld(worldName).orElseThrow(() -> new WorldNotFoundException(worldName));
    }
}
