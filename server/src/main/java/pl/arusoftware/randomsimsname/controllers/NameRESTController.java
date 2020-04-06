package pl.arusoftware.randomsimsname.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class NameRESTController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NameRESTController.class);

    private NameService nameService;

    public NameRESTController(NameService nameService) {
        this.nameService = nameService;
    }

    @PostMapping("/names")
    @ResponseBody
    public ResponseEntity<?> addNames(@RequestBody List<NameRequest> request) {
        try {
            nameService.addNames(request
                    .stream()
                    .map((entry) -> new Name(entry.getName(), Name.Gender.valueOf(entry.getGender()), false))
                    .collect(Collectors.toList()));

            List<NameResponse> response = nameService.getAllNames()
                    .stream()
                    .map((entry) -> new NameResponse(entry.getId(), entry.getGender().toString(), entry.getUsed()))
                    .collect(Collectors.toList());
            return ResponseEntity
                    .ok(response);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during add name");
        }
    }

    @PutMapping("/names")
    @ResponseBody
    public ResponseEntity<?> setIsUsedStatus(@RequestBody NameRequest request) {
        try {
            nameService.setIsUsedStatus(request.getName(), request.getIsUsed());

            List<NameResponse> response = nameService.getAllNames()
                    .stream()
                    .map((entry) -> new NameResponse(entry.getId(), entry.getGender().toString(), entry.getUsed()))
                    .collect(Collectors.toList());
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
    public ResponseEntity<?> getName(@PathParam("name") String name,
                                     @PathParam("gender") String gender) {
        try {
            Name entry;
            if (null != name && name.isBlank()) {
                entry = nameService.getName(name);
            } else {
                entry = nameService.getRandomName(gender);
            }
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
            List<NameResponse> response = nameService.getAllNames()
                    .stream()
                    .map((entry) -> new NameResponse(entry.getId(), entry.getGender().toString(), entry.getUsed()))
                    .collect(Collectors.toList());
            return ResponseEntity
                    .ok(response);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error during get all names");
        }
    }

    @DeleteMapping("/names")
    @ResponseBody
    public ResponseEntity<?> deleteName(@PathParam("name") String name) {
        try {
            nameService.deleteName(name);

            List<NameResponse> response = nameService.getAllNames()
                    .stream()
                    .map((entry) -> new NameResponse(entry.getId(), entry.getGender().toString(), entry.getUsed()))
                    .collect(Collectors.toList());
            return ResponseEntity
                    .ok(response);
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
        response.setIsUsed(entry.getUsed());
        return response;
    }
}
