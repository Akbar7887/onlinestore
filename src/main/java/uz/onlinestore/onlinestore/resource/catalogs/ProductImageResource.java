//package uz.onlinestore.onlinestore.resource.catalogs;
//
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import uz.onlinestore.onlinestore.fileupload.FileService;
//import uz.onlinestore.onlinestore.models.catalogs.Catalog;
//import uz.onlinestore.onlinestore.models.catalogs.ProductImage;
//import uz.onlinestore.onlinestore.service.catalogs.ProductImageService;
//
//import java.io.IOException;
//
//import static org.springframework.http.MediaType.parseMediaType;
//
//@RestController
//@RequestMapping("/online/doc/productimage/")
//@RequiredArgsConstructor
//public class ProductImageResource {
//
//    @Autowired
//    private final  ProductImageService productImageService;
//    private final FileService fileService;
//
//    @PostMapping(value = "upload")
//    public ResponseEntity<?> uploadAndDownload(
//            @RequestBody ProductImage productImage,
//            @RequestParam("file") MultipartFile file) {
//
////        if(productImage.getId() == null)
////        Catalog catalog = productImageService.getById(Long.parseLong(id));
////        String substr = fileService.getType(file);
////        catalog.setImagepath(catalog.getId() + substr);
////        productImageService.save(catalog);
////        return ResponseEntity.ok(productImageService.storeFile(file, catalog.getImagepath(), "catalogs"));
//    }
//
//
//    @GetMapping("download/{id:.+}")
//    public ResponseEntity<?> downloadFile(@PathVariable("id") String id, HttpServletRequest request) throws IOException {
//
//        Catalog catalog = productImageService.getById(Long.parseLong(id));
//        Resource fileResource = fileService.getFile(catalog.getImagepath(), "catalogs");
//
//        String contentType = null;
//
//        try {
//            contentType = request.getServletContext().getMimeType(fileResource.getFile().getAbsolutePath());
//        } catch (IOException e) {
//            log.error("Could not determine file type.");
//        }
//
//        if (contentType == null) {
//            contentType = "application/octet-stream";
//        }
//        return ResponseEntity.ok()
//                .contentType(parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileResource.getFilename() + "\"")
//                .body(fileResource);
//
//    }
//
//}
