package fr.epsi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
@Controller
public class AuctionController {


    @RestController
    @RequestMapping("/tags")
    public class TagsController {

        @GetMapping
        public TagListResponse getTags() {
            List<Tag> tags = Arrays.asList(
                    new Tag(1, "art"),
                    new Tag(2, "jewelry"),
                    new Tag(3, "furniture")
            );
            return new TagListResponse(tags, "List of tags");
        }

        private static class Tag {
            private final int id;
            private final String name;

            public Tag(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public String getName() {
                return name;
            }
        }

        private static class TagListResponse {
            private final List<Tag> tags;
            private final String message;

            public TagListResponse(List<Tag> tags, String message) {
                this.tags = tags;
                this.message = message;
            }

            public List<Tag> getTags() {
                return tags;
            }

            public String getMessage() {
                return message;
            }
        }
    }

}
