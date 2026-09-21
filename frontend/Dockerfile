# Use Nginx to serve the frontend
FROM nginx:alpine

# Copy frontend files to Nginx web directory
COPY index.html /usr/share/nginx/html/
COPY app.js /usr/share/nginx/html/
COPY style.css /usr/share/nginx/html/

# Expose HTTP port
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
