/*
 *
 * This file is part of Genome Artist.
 *
 * Genome Artist is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Genome Artist is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Genome Artist.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package ro.genomeartist.gui.reports.datasources;

import ro.genomeartist.gui.custompaint.ImageVector;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author iulian
 */
public class JRDataSourceImageVector implements JRDataSource {
    private ImageVector imageVector;
    private Iterator<BufferedImage> imageIterator;
    private BufferedImage currentImage;

        public JRDataSourceImageVector(ImageVector imageVector) {
            this.imageVector = imageVector;
            imageIterator = imageVector.iterator();
            currentImage = null;
        }


        public boolean next() throws JRException {
            if (imageIterator.hasNext()) {
                currentImage = imageIterator.next();
                return true;
            } else return false;
        }

        public Object getFieldValue(JRField jrField) throws JRException {
            String fieldName = jrField.getName();
            BigDecimal aux;
            int scale = 2;

             if ("sub_image".equals(fieldName)) {
                 return currentImage;
             }  else {
                 System.out.println("fieldName = "+fieldName);
                throw new JRException("No field with specified name");
             }
        }
    }
