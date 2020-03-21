package pl.arusoftware.randomsimsname.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.arusoftware.randomsimsname.controllers.data.request.NameRequest;
import pl.arusoftware.randomsimsname.controllers.data.response.NameResponse;
import pl.arusoftware.randomsimsname.data.entities.Name;
import pl.arusoftware.randomsimsname.data.exceptions.NameNotFoundException;
import pl.arusoftware.randomsimsname.services.NameService;

import javax.websocket.server.PathParam;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class NameRESTController {
    private NameService nameService;

    public NameRESTController(NameService nameService) {
        this.nameService = nameService;
    }

    @PostMapping("/name")
    @ResponseBody
    public ResponseEntity<String> addName(@RequestBody NameRequest request) {
        try {
            nameService.addName(request.getName(), request.getGender());
            return ResponseEntity
                    .ok("Name was added");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during add name");
        }
    }

    @PutMapping("/name")
    @ResponseBody
    public ResponseEntity<String> setIsUsedStatus(@RequestBody NameRequest request) {
        try {
            nameService.setIsUsedStatus(request.getName(), request.getIsUsed());
            return ResponseEntity
                    .ok("Changed name's status");
        } catch (NameNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/name")
    @ResponseBody
    public ResponseEntity<?> getName(@PathParam("name") String name) {
        try {
            Name entry = nameService.getName(name);
            NameResponse response = mapNameToResponse(entry);
            return ResponseEntity
                    .ok(response);
        } catch (NameNotFoundException e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/names")
    @ResponseBody
    public ResponseEntity<?> getAllNames() {
        try {
            Set<NameResponse> response = nameService.getAllNames()
                    .stream()
                    .map((entry) -> new NameResponse(entry.getId(), entry.getGender().toString(), entry.getUsed()))
                    .collect(Collectors.toSet());
            return ResponseEntity
                    .ok(response);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during get all names");
        }
    }

    @DeleteMapping("/name")
    @ResponseBody
    public ResponseEntity<String> deleteName(@PathParam("name") String name) {
        try {
            nameService.deleteName(name);
            return ResponseEntity
                    .ok("Name was successfully deleted");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    private NameResponse mapNameToResponse(Name entry) {
        NameResponse response = new NameResponse();
        response.setName(entry.getId());
        response.setGender(entry.getGender().toString());
        response.setUsed(entry.getUsed());
        return response;
    }
}
