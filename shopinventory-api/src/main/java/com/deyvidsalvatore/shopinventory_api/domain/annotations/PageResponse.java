package com.deyvidsalvatore.shopinventory_api.domain.annotations;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Wrapper for paginated response")
public class PageResponse<T> {

    @Schema(description = "List of content elements for the current page")
    private List<T> content;

    @Schema(description = "Page metadata")
    private PageMetadata page;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public PageMetadata getPage() {
        return page;
    }

    public void setPage(PageMetadata page) {
        this.page = page;
    }

    @Schema(description = "Page information")
    public static class PageMetadata {

        @Schema(description = "Size of the page")
        private int size;

        @Schema(description = "Current page number (zero-based)")
        private int number;

        @Schema(description = "Total number of elements")
        private long totalElements;

        @Schema(description = "Total number of pages")
        private int totalPages;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public long getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(long totalElements) {
            this.totalElements = totalElements;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }
    }
}
