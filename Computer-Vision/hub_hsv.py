import cv2
import numpy as np

#green = [36, 202, 59, 71, 255, 255]
#yellow = [18, 0, 196, 36, 255, 255]

# These are inverted colors of red and blue (see line 34)


# Initialize Video Feed(s)


# Connect to the robot

def detect():
    # Take each frameks
    hub = [58, 14, 69, 101, 255, 255]


    #Set the color
    color = hub
    image = cv2.imread("./Computer-Vision/hub_images/Terminal22ft6in.png")
   

    # Invert the image so that red can be more accurate
  
    frameHSV = cv2.cvtColor(image, cv2.COLOR_BGR2HSV)
    
    # HSV values to define a colour range we want to create a mask from.
    colorLow = np.array(color[0:3])
    colorHigh = np.array(color[3:6])
    mask = cv2.inRange(frameHSV, colorLow, colorHigh)
    kernel = np.ones((5,5),np.uint8)
   # mask = cv2.erode(mask, kernel, iterations=0)
    cv2.imshow("mask", mask)
    cv2.waitKey(10000)
    # Get the countours of the all that is in the color range
    contours, h = cv2.findContours(mask, 1, 2)
    contours = sorted(contours, key = cv2.contourArea, reverse = True)[:]

    for cnt in contours:
        # For every contour, create a circle around it
        a = cv2.minAreaRect(cnt)
        area = a[1][0]*a[1][1]
        print("minarea", cv2.minAreaRect(cnt))
        
        # Only proceed if the radius meets a minimum size
        # and if the area of the contour is atleast 75% of the enclosing circle
        print("contour area: ", cv2.contourArea(cnt))
        if area != 0 and cv2.contourArea(cnt)/area > 0.8:
            cv2.drawContours(image, cnt, -1, (0,255,0), 3 )

        

    # Show final output image
    cv2.imshow('Result', image)
    
    if cv2.waitKey(1) & 0xFF==ord('q'):
        pass

detect()   
cv2.waitKey(0)
cv2.destroyAllWindows()
