async function loadInstruments() {

    try {

        const response =
            await fetch("http://localhost:8081/api/instruments");

        const instruments =
            await response.json();

        const container =
            document.getElementById("instrument-list");

        container.innerHTML = "";

        instruments.forEach(function(instrument) {

            const item =
                document.createElement("div");

            item.innerHTML = `
                <h3>${instrument.name}</h3>
                <p>Type: ${instrument.type}</p>
                <p>Manufacturer: ${instrument.manufacturer}</p>
                <p>Status: ${instrument.status}</p>
            `;

            container.appendChild(item);
        });

    } catch (error) {

        console.error(
            "Unable to load instruments:",
            error
        );

        document.getElementById(
            "instrument-list"
        ).innerHTML =
            "<p>Unable to connect to Instrument Service.</p>";
    }
}


async function loadExperiments() {

    try {

        const response =
            await fetch("http://localhost:8082/api/experiments");

        const experiments =
            await response.json();

        const container =
            document.getElementById("experiment-list");

        container.innerHTML = "";

        experiments.forEach(function(experiment) {

            const item =
                document.createElement("div");

            item.innerHTML = `
                <h3>${experiment.name}</h3>
                <p>${experiment.description}</p>
                <p>Instrument: ${experiment.instrumentName}</p>
                <p>Status: ${experiment.status}</p>
            `;

            container.appendChild(item);
        });

    } catch (error) {

        console.error(
            "Unable to load experiments:",
            error
        );

        document.getElementById(
            "experiment-list"
        ).innerHTML =
            "<p>Unable to connect to Experiment Service.</p>";
    }
}
