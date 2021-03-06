package hu.ptemik.gallery.servlets;

import hu.ptemik.gallery.entities.Picture;
import hu.ptemik.gallery.entities.User;
import hu.ptemik.gallery.service.PictureService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author FPeter
 */
public class UploadServlet extends HttpServlet {

    private static final String UPLOAD_DIRECTORY = System.getProperty("gallery.picturesFolder");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        PictureService pictureService = new PictureService();

        if (ServletFileUpload.isMultipartContent(request) && user != null) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                Picture pic = new Picture();
                File uploadedFile = null;

                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String relativePath =  user.getUserName() + File.separator + fileName;
                        String filePath = UPLOAD_DIRECTORY + File.separator + relativePath;

                        uploadedFile = new File(filePath);
                        item.write(uploadedFile);

                        pic.setUrl(relativePath);
                    } else {
                        if (item.getFieldName().equals("title")) {
                            pic.setTitle(item.getString());
                        } else if (item.getFieldName().equals("description")) {
                            pic.setDescription(item.getString());
                        }
                    }
                }

                if (pictureService.newPicture(pic, user)) {
                    request.setAttribute("successMessage", "A fájl feltöltése sikerült!");
                } else {
                    FileUtils.deleteQuietly(uploadedFile);
                    throw new Exception();
                }
            } 
            catch (FileNotFoundException ex) {
                request.setAttribute("errorMessage", "Hiányzik a fájl!");
            }
            catch (Exception ex) {
                request.setAttribute("errorMessage", "Hiba a fájl feltöltése során!");
            }
        } else {
            request.setAttribute("errorMessage", "Form hiba");
        }

        request.getRequestDispatcher("upload.jsp").forward(request, response);
    }

}
